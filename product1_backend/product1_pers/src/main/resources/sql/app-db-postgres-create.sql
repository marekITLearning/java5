DROP DATABASE IF EXISTS imdb;

CREATE DATABASE imdb
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Slovak_Slovakia.1250'
    LC_CTYPE = 'Slovak_Slovakia.1250'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    TEMPLATE template0;