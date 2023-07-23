rmdir /s /q pmroot
C:/devel/jdk-11.0.19/bin/java.exe ^
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8088 ^
-DconfigFilePath=app_config.properties ^
-jar C:\devel\mavenrepo\fish\payara\extras\payara-micro\6.2023.7\payara-micro-6.2023.7.jar ^
--deploy ../product1_backend/product1_rest/target/restapp.war ^
--port 8081 ^
--rootDir pmroot ^
--domainConfig domain.xml