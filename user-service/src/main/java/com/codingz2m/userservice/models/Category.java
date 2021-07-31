package com.codingz2m.userservice.models;
import java.util.UUID;
public class Category {
	
	private UUID id;
	private String type;
	
	  private Plan plan;    // No Setter Method for author..
	  
	  public Category() {
			
		}
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

