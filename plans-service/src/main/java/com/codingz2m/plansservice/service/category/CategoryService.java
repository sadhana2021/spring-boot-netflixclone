package com.codingz2m.plansservice.service.category;


import java.util.UUID;

import com.codingz2m.plansservice.data.plan.Plan;

public interface CategoryService {

	Plan getPlanByIdWithCategory(UUID categoryId);
}
