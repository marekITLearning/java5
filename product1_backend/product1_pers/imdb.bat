https://www.imdb.com/interfaces/

create database

create table title

create table rating

import title and rating data from tsv files

"C:/devel/postgres/bin/psql" -d imdb -U postgres
\copy rating(tconst, averageRating, numVotes) FROM 'C:\Users\MLA\git\java5\product1_backend\product1_pers\imdb\title.rating.tsv' DELIMITER E'\t' CSV ENCODING 'UTF8' HEADER
\copy title(tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres) FROM 'C:\Users\MLA\git\java5\product1_backend\product1_pers\imdb\title.basics.tsv' DELIMITER E'\t' CSV ENCODING 'UTF8' HEADER NULL '\N' QUOTE E'\b'

spring.datasource.url=jdbc:postgresql://localhost:5432/imdb
spring.datasource.username=postgres
spring.datasource.password=sa

@Entity
@Table(name = "rating", schema = "public")
public class Rating {
@Id
private String tconst;
private Float averagerating;
private Integer numvotes;
}

public interface RatingRepository extends PagingAndSortingRepository<Rating, String> {
@Query("SELECT r FROM Rating r WHERE r.averagerating > :averagerating")
List<Rating> findByRating(@Param("averagerating") float averagerating);
}

@Bean public CommandLineRunner demo(RatingRepository ratingRepository) {
return (args) -> { 
List<Rating> top = ratingRepository.findByRating(9.8f);
System.out.println(top.size());
};
}

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "tconst", referencedColumnName = "tconst")
private Title title;

select * from rating r join title t on r.tconst = t.tconst where averagerating > 9.8

Iterable<Rating> top = ratingRepository.findByRating(9.8f);

spring jpa tutorial
