#!/bin/bash

BASE_BIN_DIR=`dirname $0`
# public env
. $BASE_BIN_DIR/base_env.sh

# private env
if [ -f $BASE_BIN_DIR/env.sh ]; then
	. $BASE_BIN_DIR/env.sh
fi

## jetty所需相关参数
TMPDIR="$JETTY_SERVER_HOME/tmp"
JETTY_CONF="$JETTY_SERVER_HOME/conf/jetty.conf"
JETTY_WEBAPPS="$JETTY_SERVER_HOME/webapps"
START_INI="$JETTY_SERVER_HOME/conf/start.ini"
JETTY_ARGS="--ini=$START_INI"
JETTY_PID="$OUTPUT_HOME/logs/jetty/jetty.pid"
JETTY_LOGS="$JETTY_SERVER_HOME/logs"
JAVA="$JAVA_HOME/bin/java" ## jetty必须执行$JAVA变量,jetty.sh启动时不依赖JAVA_HOME
## jvm参数
JAVA_OPTIONS="$JAVA_OPTS"
export TMPDIR JETTY_CONF JETTY_WEBAPPS JETTY_ARGS START_INI JETTY_PID JETTY_LOGS JAVA_OPTIONS JAVA

prepare() {
	# delete jetty work home dir, then make the jetty work
	if [ -d "$JETTY_SERVER_HOME" ] ; then
   		rm -rf  "$JETTY_SERVER_HOME"
	fi

	if [ ! -d "$JETTY_SERVER_HOME" ] ; then
    	mkdir -p "$JETTY_SERVER_HOME"
	fi
	
	# cp file to jetty server home.
	cp -r "$DEPLOY_HOME/conf/jetty/conf" $JETTY_SERVER_HOME/
	cp -r "$DEPLOY_HOME/conf/jetty/ext"  $JETTY_SERVER_HOME/
	# create dir
	mkdir -p "$OUTPUT_HOME/logs/jetty"
  	mkdir -p "$JETTY_WEBAPPS"
  	mkdir -p "$JETTY_LOGS"
  	mkdir -p "$TMPDIR"
	if [ ! -f "$OUTPUT_HOME/logs/jetty/jetty_stdout.log" ] ; then 
  		touch "$OUTPUT_HOME/logs/jetty/jetty_stdout.log"
  	fi
  	
  	if  $production_mode ; then
  		## 线上环境,通过link方式部署output/web.war
		rm -rf  "$JETTY_WEBAPPS/root.war" 
		cp  "$OUTPUT_HOME/web.war"  "$JETTY_WEBAPPS/root.war"  ## 目前只能拷贝
  	else
  		## 开发环境/测试环境
		cp $DEPLOY_HOME/../*.war  $JETTY_WEBAPPS/root.war
  	fi  	
}

run() {
	prepare
	## 启动jetty
	$JETTY_HOME/bin/jetty.sh run
}

start() {
	prepare
	## 启动jetty
	$JETTY_HOME/bin/jetty.sh start
}


stop() {
	$JETTY_HOME/bin/jetty.sh stop
}

if [ "$1" == "-v" ] || [ "$1" == "-h" ]; then
  echo "Useage: jettyctl.sh run   ##前台启动"
  echo "        jettyctl.sh start ##后台异步 jetty --daemon"
  echo "        jettyctl.sh stop  ##关闭"
elif [ "$1" == "start" ]; then
  start
elif [ "$1" == "stop" ]; then
  stop
else
  run
fi
