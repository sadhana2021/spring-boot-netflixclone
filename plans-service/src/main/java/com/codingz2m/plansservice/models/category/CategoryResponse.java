package com.codingz2m.plansservice.models.category;

import java.util.UUID;

import com.codingz2m.plansservice.data.plan.Plan;

public class CategoryResponse {
	
	private UUID id;
	private String type;
	
	private Plan plan;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}  
	
	
}
