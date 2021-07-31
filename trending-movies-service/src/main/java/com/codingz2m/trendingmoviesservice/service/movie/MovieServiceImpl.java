package com.codingz2m.trendingmoviesservice.service.movie;

import java.util.List;

import com.codingz2m.trendingmoviesservice.data.movie.Movie;
import com.codingz2m.trendingmoviesservice.data.movie.MovieRepository;
import com.codingz2m.trendingmoviesservice.data.review.Review;
import com.codingz2m.trendingmoviesservice.shared.MovieDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import java.util.UUID;

@Service
@Transactional 
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie createMovie(MovieDto movieDto) {
		 
		   ModelMapper modelMapper = new ModelMapper(); 
		   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		   Movie movie = modelMapper.map(movieDto, Movie.class);
		    movie =   movieRepository.save(movie);
		       
		return movie;
		}

	@Override
	public List<Review> getMovieByIdWithReviews(UUID movieId) {
	List <Review> reviewsList = new ArrayList<>();
		
		Optional<Movie> movie = movieRepository.findById(movieId);
				Movie movieObject = movie.get();
				reviewsList =	movieObject.retrieveReviews();
		return reviewsList ;

	}

	@Override
	public List<MovieDto> getMovies() {
		List <MovieDto> movieDtoList = new ArrayList<>();
		
		Iterable <Movie> movieList = movieRepository.findAll();
		
		 ModelMapper modelMapper = new ModelMapper(); 
		   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		    movieDtoList = Arrays.asList(modelMapper.map(movieList, MovieDto[].class));
		      
		return movieDtoList;
}

	@Override
	public MovieDto getMovie(UUID movieId) {
	
		Optional<Movie> movieOptional = movieRepository.findById(movieId);
		Movie movie = movieOptional.get();
		
		 ModelMapper modelMapper = new ModelMapper(); 
		   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		    MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
		      
		return movieDto;
		}

	
	@Override
	public int updateMovie(MovieDto movieDto, UUID movieId) {
		int  updateMovieCount;
		ModelMapper modelMapper = new ModelMapper(); 
		  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		 Movie movie = modelMapper.map(movieDto, Movie.class);
		   updateMovieCount =  movieRepository.updateMovie(movieId, movie.getOriginalLanguage());
		    
		return  updateMovieCount;
	}

	
	@Override
	public MovieDto getMovieByOrginalTitleAndLanguage(String originalLanguage, String originalTitle) {
		
		Movie movie = movieRepository.findMovieByOriginalTitleAndLanguage(originalLanguage, originalTitle);
		
		 ModelMapper modelMapper = new ModelMapper(); 
		   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		    MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
		      
		return movieDto;
		
	}

	

}
