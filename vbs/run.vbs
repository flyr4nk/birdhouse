'---------------ע�����---------------
Set ws=createobject("wscript.shell")
ws.run "regsvr32  /s D:\vbs\mk.dll"

'---------------����⺯��-------------
Dim fso
set fso = createobject("scripting.filesystemobject")
ExecuteGlobal fso.opentextfile("d:/vbs/script.vbs", 1).readall
Set fso = nothing

'---------------���ļ���ȡ��������----------------
Dim datafile
Set objArgs = WScript.Arguments
datafile = LCase(objArgs(0))


dim dfso
set dfso = createobject("scripting.filesystemobject")
ExecuteGlobal dfso.opentextfile(datafile, 1).readall
Set dfso = nothing


Dim hand,retvalue


'�������������url����
Set ie = openIeExplore(url)
'�ȴ��������
WScript.sleep 5000


set hand = CreateObject("mk.hand")

'����ÿһ�β����¼�������
Dim eventArry
eventArry=split(eventStr,"|")

'��ÿһ���¼�������
For i=0 to UBound(eventArry)
  Dim pEvent,eData
  	pEvent = eventArry(i)
  	eData = split(pEvent,"_")
	If eData(0) = "click" Then 
		retvalue = hand.Click(eData(1),eData(2),eData(5)*1000)
  End If
Next

'�ر������
CloseIeExplore(ie)

'�����ļ�������ʶִ�гɹ�
renameFile(datafile)









