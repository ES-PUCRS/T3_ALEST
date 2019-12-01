SET mypath=%~dp0..
cd %mypath%

if NOT ["%ERRORLEVEL%"] == ["0"] EXIT

java -cp .\ src.app

PAUSE