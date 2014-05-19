set path="E:\j2sdk1.4.2_08\bin"
set classpath=E:\Group-Portfolio-RMI-master
javac *.java
start rmiregistry
rmic PlayerDB
rmic PlayerApp
start java AppServer
start java DBServer
