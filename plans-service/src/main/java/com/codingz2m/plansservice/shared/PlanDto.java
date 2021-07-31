package com.codingz2m.plansservice.shared;

import java.util.UUID;

import com.codingz2m.plansservice.data.category.Category;

public class PlanDto {
	private UUID id;
	private double monthlyCost;
	private int numberOfScreens;
	private int numberOfTabletDownloads;
	private boolean UnlimitedMoviesAndTvShows;
	private boolean watchOnTablet;
	private boolean watchOnLaptopAndTv;
	private boolean hDAvailable;
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
