package com.codingz2m.actionmoviesservice.shared;

import java.util.UUID;

import com.codingz2m.actionmoviesservice.data.movie.Movie;

public class ReviewDto {

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
