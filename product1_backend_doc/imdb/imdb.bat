rem https://www.imdb.com/interfaces/

"C:/devel/postgresql/12.7/bin/psql" -d imdb -U postgres

\copy title(tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres) FROM 'title.basics.tsv' DELIMITER E'\t' CSV ENCODING 'UTF8' HEADER NULL '\N' QUOTE E'\b'

\copy rating(tconst, averageRating, numVotes) FROM 'title.rating.tsv' DELIMITER E'\t' CSV ENCODING 'UTF8' HEADER
