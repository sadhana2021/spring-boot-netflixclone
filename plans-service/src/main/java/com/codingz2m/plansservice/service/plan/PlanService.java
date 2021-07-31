package com.codingz2m.plansservice.service.plan;

import com.codingz2m.plansservice.data.plan.Plan;
import com.codingz2m.plansservice.shared.PlanDto;

public interface PlanService {
	Plan createPlanWithCategoryId(PlanDto planDto);
}
