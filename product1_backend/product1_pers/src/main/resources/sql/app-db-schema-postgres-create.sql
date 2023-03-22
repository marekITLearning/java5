CREATE TABLE public.title
(
	tconst text,
	titleType text,
	primaryTitle text,
	originalTitle text,
	isAdult boolean,
	startYear integer,
	endYear integer,
	runtimeMinutes integer,
	genres text,
    CONSTRAINT title_pkey PRIMARY KEY (tconst)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.title OWNER to postgres;

CREATE TABLE public.rating
(
	tconst text,
	averageRating numeric(3,1),
	numVotes integer,
    CONSTRAINT rating_pkey PRIMARY KEY (tconst)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.rating OWNER to postgres;