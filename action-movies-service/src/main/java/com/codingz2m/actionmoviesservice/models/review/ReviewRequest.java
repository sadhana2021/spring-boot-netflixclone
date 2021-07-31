package com.codingz2m.actionmoviesservice.models.review;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.codingz2m.actionmoviesservice.data.movie.Movie;

import javax.validation.constraints.NotNull;

public class ReviewRequest {
	@Null
	private UUID id;
	@NotNull(message="Rating Cannot Be Null")
		private float rating;
	@NotNull(message="Description Cannot Be Null")
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
	
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
	
	}
