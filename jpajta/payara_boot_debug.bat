REM !!! Minimum Required JDK version to run this payara server is 8u162 !!!

C:\devel\jdk8172\bin\java.exe -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=8000 -jar C:\devel\payara5-micro\payara-micro-5.184.jar --port 8081 --deploy target/restapi.war
