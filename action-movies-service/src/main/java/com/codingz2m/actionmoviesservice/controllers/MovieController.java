package com.codingz2m.actionmoviesservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.actionmoviesservice.data.movie.Movie;
import com.codingz2m.actionmoviesservice.data.review.Review;
import com.codingz2m.actionmoviesservice.models.movie.MovieRequest;
import com.codingz2m.actionmoviesservice.models.movie.MovieResponse;
import com.codingz2m.actionmoviesservice.models.review.ReviewResponse;
import com.codingz2m.actionmoviesservice.service.movie.MovieService;
import com.codingz2m.actionmoviesservice.shared.MovieDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.MediaType;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/action_movie")
public class MovieController {
	@Autowired
	private Environment env;
	private MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	@GetMapping("/status/check")
	public String status() throws UnknownHostException {
		return "Trending Movie Service:  working on port - " + env.getProperty("server.port") + 
				"   Host Address: " + InetAddress.getLocalHost().getHostAddress() + 
				"   Host Name: " + InetAddress.getLocalHost().getHostName();
	}



	// HTTP POST with SpringMVC
	@PostMapping(
					consumes= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
					produces= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
				)
		public ResponseEntity<MovieResponse> createMovie(@Valid @RequestBody MovieRequest movieRequest) {

			ModelMapper modelMapper = new ModelMapper(); 	
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

			MovieDto movieDto = modelMapper.map( movieRequest, MovieDto.class); 		
			Movie movie  = movieService.createMovie(movieDto);

			MovieResponse movieResponse = modelMapper.map(movie, MovieResponse.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
	}
	
	

	// HTTP GET with Spring MVC
//  One-To-Many Mapping (BI-Directional: From  Movie To List <Review> Object)
	  @GetMapping(path ="/{movieId}/reviews")
	    public ResponseEntity<List<ReviewResponse >> getReviewsForMovie(@PathVariable UUID movieId){
		
		 
		  List <ReviewResponse> reviewResponses   = new ArrayList<>();
		  
		  ModelMapper modelMapper = new ModelMapper(); 	
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			
			 List<Review> reviewsList = movieService.getMovieByIdWithReviews(movieId);
			  
			reviewResponses = Arrays.asList( modelMapper.map(reviewsList, ReviewResponse[].class));
			return ResponseEntity.status(HttpStatus.FOUND).body(reviewResponses  );
			
	    }


	 	@GetMapping (path="/movies")
		 public ResponseEntity<List<MovieResponse >> getAllMovies( ) {  
			
			List <MovieResponse> movieList = new ArrayList<>();
			
			Iterable <MovieDto> movieDtoList = movieService.getMovies();
			
			 ModelMapper modelMapper = new ModelMapper(); 
			   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			   
			   movieList = Arrays.asList(modelMapper.map(movieDtoList, MovieResponse[].class));
			   return ResponseEntity.status(HttpStatus.FOUND).body( movieList );
			
		 }
	

	 	
	 	@GetMapping (path="/{movieId}")
		 public ResponseEntity<MovieResponse> getMovie( @PathVariable UUID movieId ) {  
	 		
	 		
	        MovieDto movieDto = movieService.getMovie(movieId);
			
			 ModelMapper modelMapper = new ModelMapper(); 
			   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			   
			   
			   MovieResponse movieResponse = modelMapper.map(movieDto, MovieResponse.class);
			 return ResponseEntity.status(HttpStatus.FOUND).body( movieResponse );
		 }
	
	 	

		// HTTP PUT with Spring MVC
		@PutMapping( path ="/{movieId}",
				consumes= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
				produces= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
			)
		public ResponseEntity<Integer> updateMovie(
													@RequestBody MovieRequest movieRequest,
													@PathVariable UUID movieId) {
			int  updateMovieCount;
			
			
		ModelMapper modelMapper = new ModelMapper(); 	
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		MovieDto movieDto = modelMapper.map( movieRequest, MovieDto.class); 		
		updateMovieCount  = movieService.updateMovie(movieDto, movieId);

		//MovieResponse movieResponse = modelMapper.map(movie, MovieResponse.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateMovieCount);
		}


		@GetMapping (path="/{originalLanguage}/{originalTitle}")
		 public ResponseEntity<MovieResponse> getMovieByOriginalTitleAndLanguage( @PathVariable String originalLanguage,
				 										@PathVariable String originalTitle) {  
	 		
	 		
	        MovieDto movieDto = movieService.getMovieByOrginalTitleAndLanguage(originalLanguage, originalTitle);
			
			 ModelMapper modelMapper = new ModelMapper(); 
			   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			   
			   
			   MovieResponse movieResponse = modelMapper.map(movieDto, MovieResponse.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
		 }
	
}

