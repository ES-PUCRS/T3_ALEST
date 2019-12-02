SET mypath=%~dp0
cd %mypath%

%mypath%Build.bat && cls && %mypath%Compile.bat

EXIT