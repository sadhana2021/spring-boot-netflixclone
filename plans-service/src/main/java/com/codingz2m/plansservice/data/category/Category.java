package com.codingz2m.plansservice.data.category;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.codingz2m.plansservice.data.plan.Plan;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable=false, length=20)
	private String type;
	
	  @OneToOne(mappedBy = "category") // Connecting Contact with Author
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

	public Plan retrievePlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	
	
	

}
