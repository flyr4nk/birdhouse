#!/bin/bash

####cp css/js/image   static files#####
echo "start copy htdocs......"
cp -Rf /opt/scm/framework/deploy/htdocs /var/www/html/

######cp template ######
echo "start copy templates ......"
cp -Rf /opt/scm/framework/deploy/templates/* /templates
