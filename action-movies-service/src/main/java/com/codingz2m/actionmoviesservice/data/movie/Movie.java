package com.codingz2m.actionmoviesservice.data.movie;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.codingz2m.actionmoviesservice.data.review.Review;

import java.util.UUID;


@Entity
@Table(name="action_movie")
public class Movie {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable=false, length=3)
	private String originalLanguage;
	@Column(name= "", nullable=false, length=100)
	private String originalTitle;
	@Column(nullable=false, length=300)
	private String posterPath;
	@Column(nullable=false, length=1000)
	private String overview;
	@Column(nullable=false, length=30)
	private String releaseDate;
	@Column(nullable=false, length=6)
	private boolean adult;
	@Column(nullable=false, length=300)
	private String backdropPath;
	@Column(nullable=false, length=6)
	private String mediaType;
	@Column(nullable=false, length=20)
	private String type;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="movie", 
			cascade=CascadeType.ALL, orphanRemoval = true)
	 private List<Review> reviews;
	 
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getBackdropPath() {
		return backdropPath;
	}
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Review> retrieveReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	

}

