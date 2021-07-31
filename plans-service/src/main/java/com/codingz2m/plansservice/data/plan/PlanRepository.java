package com.codingz2m.plansservice.data.plan;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;


public interface PlanRepository extends CrudRepository<Plan, UUID>{

}
