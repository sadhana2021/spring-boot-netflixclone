package com.codingz2m.plansservice.models.plan;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.codingz2m.plansservice.data.category.Category;

public class PlanRequest {
	@Null
	private UUID id;
	@NotNull(message="Monthly Cost Cannot Be Null")
	private double monthlyCost;
	@NotNull(message="Number Of Screens Cannot Be Null")
	private int numberOfScreens;
	@NotNull(message="Number Of Tablet Downloads Cannot Be Null")
	private int numberOfTabletDownloads;
	@NotNull(message="Unlimited Movies & Tv Shows Cannot Be Null")
	private boolean UnlimitedMoviesAndTvShows;
	@NotNull(message="Watch On Tablet Cannot Be Null")
	private boolean watchOnTablet;
	@NotNull(message="Watch On Laptop & Tv Cannot Be Null")
	private boolean watchOnLaptopAndTv;
	@NotNull(message="HD Available Cannot Be Null")
	private boolean hDAvailable;
	@NotNull(message="Ultra HD Available Cannot Be Null")
	private boolean ultraHdAvailable;
	
	private Category category;

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
