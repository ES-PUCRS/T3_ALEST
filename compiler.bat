SET mypath=%~dp0
cd %mypath%src

javac ./algorithms/datastructures/*.java ./algorithms/exceptions/*.java ./algorithms/tree/*.java ./*.java

java -cp %mypath% src.app

PAUSE