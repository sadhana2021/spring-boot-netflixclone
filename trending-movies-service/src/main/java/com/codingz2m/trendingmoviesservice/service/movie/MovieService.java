package com.codingz2m.trendingmoviesservice.service.movie;

import java.util.List;

import com.codingz2m.trendingmoviesservice.data.movie.Movie;
import com.codingz2m.trendingmoviesservice.data.review.Review;
import com.codingz2m.trendingmoviesservice.shared.MovieDto;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;

public interface MovieService {

	Movie createMovie(MovieDto movieDto);
	
	List<Review> getMovieByIdWithReviews(UUID movieId);
	
	List <MovieDto> getMovies();
	
	MovieDto getMovie(UUID movieId);
	
	int updateMovie(MovieDto movieDto, UUID movieId);
	
	MovieDto getMovieByOrginalTitleAndLanguage(String originalLanguage,String orginalTitle);
}
