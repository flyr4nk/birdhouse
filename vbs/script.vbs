'打开新的ie浏览器,输入指定的url
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

'退出ie浏览器
Function CloseIeExplore(ieObj)
	ieObj.quit
End Function


'rename文件，表示已经执行完成
Function renameFile(fileStr)
  Dim fileObj
	Set fso = CreateObject("Scripting.FileSystemObject")
	Set fileObj = fso.GetFile(fileStr)
	fileObj.move(fileStr+".ok")
	Set fso = nothing
End Function

