rmdir /s /q pmroot
C:/devel/jdk-11.0.8/bin/java.exe ^
-agentpath:C:\devel\eclipse\plugins\org.zeroturnaround.eclipse.embedder_2020.3.0.RELEASE\jrebel\lib\jrebel64.dll ^
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8088 ^
-jar C:/devel/payara-micro-5.2020.5.jar ^
--deploy ../product1_backend/product1_rest/target/restapi.war ^
--port 8080 ^
--rootDir pmroot ^
--domainConfig domain.xml