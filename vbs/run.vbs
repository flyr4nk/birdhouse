'---------------注册组件---------------
Set ws=createobject("wscript.shell")
ws.run "regsvr32  /s D:\vbs\mk.dll"

'---------------导入库函数-------------
Dim fso
set fso = createobject("scripting.filesystemobject")
ExecuteGlobal fso.opentextfile("d:/vbs/script.vbs", 1).readall
Set fso = nothing

'---------------从文件读取运行数据----------------
Dim datafile
Set objArgs = WScript.Arguments
datafile = LCase(objArgs(0))


dim dfso
set dfso = createobject("scripting.filesystemobject")
ExecuteGlobal dfso.opentextfile(datafile, 1).readall
Set dfso = nothing


Dim hand,retvalue


'打开浏览器，输入url连接
Set ie = openIeExplore(url)
'等待加载完成
WScript.sleep 5000


set hand = CreateObject("mk.hand")

'定义每一次操作事件的数组
Dim eventArry
eventArry=split(eventStr,"|")

'对每一个事件做操作
For i=0 to UBound(eventArry)
  Dim pEvent,eData
  	pEvent = eventArry(i)
  	eData = split(pEvent,"_")
	If eData(0) = "click" Then 
		retvalue = hand.Click(eData(1),eData(2),eData(5)*1000)
  End If
Next

'关闭浏览器
CloseIeExplore(ie)

'更改文件名，标识执行成功
renameFile(datafile)









