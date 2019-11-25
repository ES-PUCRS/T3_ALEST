SET mypath=%~dp0..\..\src
cd %mypath%

move .\algorithms\datastructures\*.class .\algorithms\datastructures\backup\
move .\algorithms\exceptions\*.class .\algorithms\exceptions\backup\
move .\algorithms\tree\*.class .\algorithms\tree\backup\
move .\*.class .\backup\