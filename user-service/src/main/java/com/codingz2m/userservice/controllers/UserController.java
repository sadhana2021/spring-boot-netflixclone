package com.codingz2m.userservice.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.userservice.models.PlanResponse;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	@Autowired
	private Environment env;
	
	@Autowired
	private PlanServiceProxy planServiceProxy;
	
	@GetMapping("/status/check")
	public String status() throws UnknownHostException {
		return "Trending Movie Service:  working on port - " + env.getProperty("server.port") + 
				"   Host Address: " + InetAddress.getLocalHost().getHostAddress() + 
				"   Host Name: " + InetAddress.getLocalHost().getHostName();
	}
	
	
	//http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
		@GetMapping("/{categoryId}/plan")
		public ResponseEntity<PlanResponse> getPlan(@PathVariable UUID categoryId) {

			
			PlanResponse planResponse = planServiceProxy.getPlanForCategory(categoryId);
			System.out.print(planResponse.getMonthlyCost());
			return ResponseEntity.status(HttpStatus.CREATED).body(planResponse);
		}
}
