rmdir /s /q pmroot
C:/devel/jdk-11.0.5/bin/java.exe -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar C:/devel/payara-micro-5.193.jar --deploy target/restapi.war --rootDir pmroot