package com.codingz2m.actionmoviesservice.data.movie;


import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends CrudRepository<Movie, UUID>  {
	
	// Using Spring Data JPA @Query
	// Custom Queries with @Query Annotation
	// Creating JPA-based repository layer, using Spring Data JPA
	
	  // JPQL Update @Query
	  @Modifying
	    @Query("UPDATE Movie m SET m.originalLanguage = :originalLanguage WHERE m.id = :id")
	    int updateMovie(@Param("id") UUID id, @Param("originalLanguage") String originalLanguage);
	  
	  
	  /* JPQL Select @Query with Index Parameters
		Passing method parameters to a query through an indexes.
	  */	
	//  @Query("select m from Movie m where m.originalLanguage =  ?1 and m.originalTitle = ?2")
	//  public Movie findMovieByOriginalTitle(String originalLanguage, String originalTitle);

	  
	  /*
	  JPQL @Query with Named Parameters
	  Another approach to pass parameters to a query is with named parameters.
	  In this approach, you pass the method parameter values to the query bind parameters.
	  */
	  
	  @Query("select m from Movie m where m.originalLanguage = :originalLanguage and m.originalTitle = :originalTitle")
	  public Movie findMovieByOriginalTitleAndLanguage(@Param("originalLanguage") String originalLanguage, @Param("originalTitle") String originalTitle);

	  
	  /*
	   Sorting with @Query
	   To sort query results, in Spring Data JPA provides a special Sort parameter. 
	   When you use the Sort parameter, Spring Data JPA will generate the
	    ORDER_BY clause automatically.

		
		@Query("select m from Movie m where m.originalTitle = ?1")
		List<Movie> findMovieByOriginalTitleAndSort(String originalTitle, Sort sort);
	   */
	   
}
