package com.codingz2m.trendingmoviesservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.trendingmoviesservice.data.review.Review;
import com.codingz2m.trendingmoviesservice.models.movie.MovieRequest;
import com.codingz2m.trendingmoviesservice.models.review.ReviewRequest;
import com.codingz2m.trendingmoviesservice.models.review.ReviewResponse;
import com.codingz2m.trendingmoviesservice.service.movie.MovieService;
import com.codingz2m.trendingmoviesservice.service.review.ReviewService;
import com.codingz2m.trendingmoviesservice.shared.MovieDto;
import com.codingz2m.trendingmoviesservice.shared.ReviewDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/trending_movie_reviews")
public class ReviewController {
	
	@Autowired
	private Environment env;
	private ReviewService reviewService;
	
	@Autowired
	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}


	@GetMapping("/status/check")
	public String status() {
		return "Trending Movie Service:  working on port" + env.getProperty("local.server.port");
	}

	
	// HTTP POST with SpringMVC - Create new Product
	@PostMapping(
			consumes= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
		)
	public ResponseEntity<ReviewResponse> createReviewForMovie( @Valid @RequestBody ReviewRequest reviewRequest) {

	ModelMapper modelMapper = new ModelMapper(); 	
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	ReviewDto reviewDto = modelMapper.map( reviewRequest, ReviewDto.class); 		
	Review review  = reviewService.createReviewWithMovieId(reviewDto);

	ReviewResponse reviewResponse = modelMapper.map(review, ReviewResponse.class);
	return ResponseEntity.status(HttpStatus.CREATED).body(reviewResponse);
}
	
	

	// HTTP DELETE with Spring MVC
			@DeleteMapping( path ="/reviewId}",
							consumes= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
							produces= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
						)
					public ResponseEntity<Integer> deleteReview(@PathVariable UUID movieId) {
						int  deleteReviewCount;
						
						deleteReviewCount  = reviewService.deleteReview(movieId);

					//MovieResponse movieResponse = modelMapper.map(movie, MovieResponse.class);
					return ResponseEntity.status(HttpStatus.CREATED).body(deleteReviewCount);
					}

			


}
