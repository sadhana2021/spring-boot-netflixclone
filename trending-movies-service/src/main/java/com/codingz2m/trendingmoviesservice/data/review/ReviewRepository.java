package com.codingz2m.trendingmoviesservice.data.review;
import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ReviewRepository extends CrudRepository<Review, UUID> {
	
	// Custom Queries with @Query Annotation
	// Creating JPA-based repository layer, using Spring Data JPA
	
	@Modifying
	  @Query("delete from Review r where r.id = :id")
	  public int deleteReview(@Param("id") UUID id);

}
