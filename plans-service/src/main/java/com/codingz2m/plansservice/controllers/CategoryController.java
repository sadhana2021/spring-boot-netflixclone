package com.codingz2m.plansservice.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.plansservice.data.category.Category;
import com.codingz2m.plansservice.data.plan.Plan;
import com.codingz2m.plansservice.models.category.CategoryRequest;
import com.codingz2m.plansservice.models.category.CategoryResponse;
import com.codingz2m.plansservice.models.plan.PlanRequest;
import com.codingz2m.plansservice.models.plan.PlanResponse;
import com.codingz2m.plansservice.service.category.CategoryService;
import com.codingz2m.plansservice.shared.CategoryDto;
import com.codingz2m.plansservice.shared.PlanDto;


@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	
	@Autowired
	private Environment env;
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping("/status/check")
	public String status() throws UnknownHostException {
		return "Trending Movie Service:  working on port - " + env.getProperty("server.port") + 
				"   Host Address: " + InetAddress.getLocalHost().getHostAddress() + 
				"   Host Name: " + InetAddress.getLocalHost().getHostName();
	}
	
	
	// HTTP GET with Spring MVC
//  One-To-Many Mapping (BI-Directional: From  Category To Plan Object)
	  @GetMapping(path ="/{categoryId}/plan")
	    public PlanResponse getPlanForCategory(@PathVariable UUID categoryId){
		
		  PlanResponse planResponse;
		  
		  ModelMapper modelMapper = new ModelMapper(); 	
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			
			 Plan plan = categoryService.getPlanByIdWithCategory(categoryId);
			  
			planResponse =  modelMapper.map(plan, PlanResponse.class);
			return planResponse;
			
	    }
	

}
