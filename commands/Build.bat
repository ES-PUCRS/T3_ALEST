SET mypath=%~dp0..\src
cd %mypath%

javac -d %mypath%\..\bin .\algorithms\datastructures\*.java .\exceptions\*.java .\algorithms\tree\*.java .\ui\*.java .\*.java

if NOT ["%ERRORLEVEL%"]==["0"] PAUSE