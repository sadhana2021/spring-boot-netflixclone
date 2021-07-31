package com.codingz2m.trendingmoviesservice.models.review;

import java.util.UUID;

import com.codingz2m.trendingmoviesservice.data.movie.Movie;

public class ReviewResponse {
	
	private UUID id;
	private float rating;
	private String description;
	
	private Movie movie;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
	


}
