SET mypath=%~dp0
cd %mypath%

%mypath%backup\ClearBackup.bat && %mypath%backup\BackupClass.bat && %mypath%Build.bat && %mypath%Compile.bat

PAUSE