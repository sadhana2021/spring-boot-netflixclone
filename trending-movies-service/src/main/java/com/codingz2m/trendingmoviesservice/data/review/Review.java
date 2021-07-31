package com.codingz2m.trendingmoviesservice.data.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;
import com.codingz2m.trendingmoviesservice.data.movie.Movie;

@Entity
@Table(name="trending_movie_review")
public class Review {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable=false, length=7)
	private float rating;
	@Column(nullable=false, length=500)
	private String description;
	
	@ManyToOne 
	@JoinColumn(name="trending_movie_id")
    private Movie movie;
    
	
public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
public Movie getMovie() {
	return movie;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}
	


}
