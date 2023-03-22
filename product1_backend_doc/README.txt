1. add JAVA_HOME to apache maven
 - edit C:\devel\apache-maven-3.9.1\bin\mvn.cmd
 - add line
set JAVA_HOME=C:/devel/jdk-17.0.6

2. edit C:\devel\apache-maven-3.9.1\conf\settings.xml
 - uncommment   <localRepository>/path/to/local/repo</localRepository>
 - change to   <localRepository>C:/devel/repo</localRepository>

3. 
- opend cmd
- cd c:\devel\projects\java5\product1_backend
- launch build.bat to build backend application

4. Visit https://www.imdb.com/interfaces/ 
 - download title.basics.tsv.gz and title.rating.tsv.gz
 - unzip title.basics.tsv.gz to C:\devel\projects\java5\product1_backend_doc with file name title.basics.tsv
 - unzip title.rating.tsv.gz to C:\devel\projects\java5\product1_backend_doc with file name title.rating.tsv

5.
- opend cmd
- cd c:\devel\projects\java5\product1_backend_doc
- run command (to create imdb database)
"C:\devel\PostgreSQL\12.7\bin\psql" -U postgres -a -q -f ..\product1_backend\product1_pers\src\main\resources\sql\app-db-postgres-create.sql

- run command (to create database schema (tablese))
"C:\devel\PostgreSQL\12.7\bin\psql" -U postgres -d imdb -a -q -f ..\product1_backend\product1_pers\src\main\resources\sql\app-db-schema-postgres-create.sql

- connect to db with command
"C:\devel\PostgreSQL\15\bin\psql" -d imdb -U postgres

\copy title(tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres) FROM 'title.basics.tsv' DELIMITER E'\t' CSV ENCODING 'UTF8' HEADER NULL '\N' QUOTE E'\b'

\copy rating(tconst, averageRating, numVotes) FROM 'title.rating.tsv' DELIMITER E'\t' CSV ENCODING 'UTF8' HEADER
