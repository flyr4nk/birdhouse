'���µ�ie�����,����ָ����url
Function openIeExplore(url)
	Dim ieObj
	Set ieObj = WScript.CreateObject("InternetExplorer.Application") 
	ieObj.visible = True
	ieObj.Width=800
	ieObj.Height=800
	ieObj.Left=0
	ieObj.Top=0 
	ieObj.navigate url
	Set openIeExplore = ieObj
End Function

'�˳�ie�����
Function CloseIeExplore(ieObj)
	ieObj.quit
End Function


'rename�ļ�����ʾ�Ѿ�ִ�����
Function renameFile(fileStr)
  Dim fileObj
	Set fso = CreateObject("Scripting.FileSystemObject")
	Set fileObj = fso.GetFile(fileStr)
	fileObj.move(fileStr+".ok")
	Set fso = nothing
End Function

