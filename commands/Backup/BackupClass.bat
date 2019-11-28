SET mypath=%~dp0..\..\src
cd %mypath%

move .\algorithms\datastructures\*.class .\algorithms\datastructures\backup\
move .\algorithms\tree\*.class .\algorithms\tree\backup\
move .\exceptions\*.class .\exceptions\backup\
move .\*.class .\backup\