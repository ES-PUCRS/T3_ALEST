SET mypath=%~dp0..\src
cd %mypath%

:run_again
javac .\algorithms\datastructures\*.java .\exceptions\*.java .\algorithms\tree\*.java .\*.java

if NOT ["%ERRORLEVEL%"]==["0"] PAUSE