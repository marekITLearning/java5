rmdir /s /q pmroot
C:/devel/jdk-11.0.17/bin/java.exe ^
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8088 ^
-DconfigFilePath=app_config.properties ^
-jar C:\devel\repo\fish\payara\extras\payara-micro\5.2021.2\payara-micro-5.2021.2.jar ^
--deploy ../product1_backend/product1_rest/target/restapi.war ^
--port 8080 ^
--rootDir pmroot ^
--domainConfig domain.xml