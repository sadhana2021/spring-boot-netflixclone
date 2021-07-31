package com.codingz2m.userservice.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingz2m.userservice.models.PlanResponse;

import java.util.UUID;

// ****** MAKING REST CALLS USING FEIGN CLIENT **********

@FeignClient(name = "plans", url = "${PLANS_SERVICE_HOST:http://localhost}:8083")

public interface PlanServiceProxy {

	@GetMapping("api/v1/category/{categoryId}/plan")
	public PlanResponse getPlanForCategory(@PathVariable UUID categoryId);
}
