package com.codingz2m.plansservice.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.codingz2m.plansservice.data.plan.Plan;

import com.codingz2m.plansservice.models.plan.PlanRequest;
import com.codingz2m.plansservice.models.plan.PlanResponse;
import com.codingz2m.plansservice.service.plan.PlanService;
import com.codingz2m.plansservice.shared.PlanDto;

@RestController
@RequestMapping("api/v1/plan")
public class PlanController {
	
	@Autowired
	private Environment env;
	private PlanService planService;
	
	@Autowired
	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}

	@GetMapping("/status/check")
	public String status() throws UnknownHostException {
		return "Trending Movie Service:  working on port - " + env.getProperty("server.port") + 
				"   Host Address: " + InetAddress.getLocalHost().getHostAddress() + 
				"   Host Name: " + InetAddress.getLocalHost().getHostName();
	}
	
	  @PostMapping 		        
	  public ResponseEntity<PlanResponse> createPlanWithCategory(@RequestBody PlanRequest planRequest) {
	    	  
	    
	   ModelMapper modelMapper = new ModelMapper(); 	
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		PlanDto planDto = modelMapper.map( planRequest, PlanDto.class); 		
		Plan plan  = planService.createPlanWithCategoryId(planDto);

		PlanResponse planResponse = modelMapper.map(plan, PlanResponse.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(planResponse);
	}

}
