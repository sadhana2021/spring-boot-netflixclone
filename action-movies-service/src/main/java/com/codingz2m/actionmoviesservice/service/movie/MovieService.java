package com.codingz2m.actionmoviesservice.service.movie;

import java.util.List;
import java.util.UUID;

import com.codingz2m.actionmoviesservice.data.movie.Movie;
import com.codingz2m.actionmoviesservice.data.review.Review;
import com.codingz2m.actionmoviesservice.shared.MovieDto;

public interface MovieService {

	Movie createMovie(MovieDto movieDto);
	
	List<Review> getMovieByIdWithReviews(UUID movieId);
	
	List <MovieDto> getMovies();
	
	MovieDto getMovie(UUID movieId);
	
	int updateMovie(MovieDto movieDto, UUID movieId);
	
	MovieDto getMovieByOrginalTitleAndLanguage(String originalLanguage,String orginalTitle);
}
