package com.codingz2m.plansservice.models.category;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.codingz2m.plansservice.data.plan.Plan;

public class CategoryRequest {
	@Null
	private UUID id;
	@NotNull(message="Category Type Cannot Be Null")
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
