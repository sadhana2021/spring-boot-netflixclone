package com.codingz2m.plansservice.data.plan;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.codingz2m.plansservice.data.category.Category;

@Entity
@Table(name="plan")
public class Plan {
	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable=false, length=10)
	private double monthlyCost;
	@Column(nullable=false, length=4)
	private int numberOfScreens;
	@Column(nullable=false, length=4)
	private int numberOfTabletDownloads;
	@Column(nullable=false, length=10)
	private boolean UnlimitedMoviesAndTvShows;
	@Column(nullable=false, length=10)
	private boolean watchOnTablet;
	@Column(nullable=false, length=10)
	private boolean watchOnLaptopAndTv;
	@Column(nullable=false, length=10)
	private boolean hDAvailable;
	@Column(nullable=false, length=10)
	private boolean ultraHdAvailable;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)  
	@JoinColumn(name="category_id")
	private Category category;

	public Plan() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public double getMonthlyCost() {
		return monthlyCost;
	}

	public void setMonthlyCost(double monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

	public int getNumberOfScreens() {
		return numberOfScreens;
	}

	public void setNumberOfScreens(int numberOfScreens) {
		this.numberOfScreens = numberOfScreens;
	}

	public int getNumberOfTabletDownloads() {
		return numberOfTabletDownloads;
	}

	public void setNumberOfTabletDownloads(int numberOfTabletDownloads) {
		this.numberOfTabletDownloads = numberOfTabletDownloads;
	}

	public boolean isUnlimitedMoviesAndTvShows() {
		return UnlimitedMoviesAndTvShows;
	}

	public void setUnlimitedMoviesAndTvShows(boolean unlimitedMoviesAndTvShows) {
		UnlimitedMoviesAndTvShows = unlimitedMoviesAndTvShows;
	}

	public boolean isWatchOnTablet() {
		return watchOnTablet;
	}

	public void setWatchOnTablet(boolean watchOnTablet) {
		this.watchOnTablet = watchOnTablet;
	}

	public boolean isWatchOnLaptopAndTv() {
		return watchOnLaptopAndTv;
	}

	public void setWatchOnLaptopAndTv(boolean watchOnLaptopAndTv) {
		this.watchOnLaptopAndTv = watchOnLaptopAndTv;
	}

	public boolean ishDAvailable() {
		return hDAvailable;
	}

	public void sethDAvailable(boolean hDAvailable) {
		this.hDAvailable = hDAvailable;
	}

	public boolean isUltraHdAvailable() {
		return ultraHdAvailable;
	}

	public void setUltraHdAvailable(boolean ultraHdAvailable) {
		this.ultraHdAvailable = ultraHdAvailable;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
