package com.codingz2m.plansservice.service.category;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz2m.plansservice.data.category.Category;
import com.codingz2m.plansservice.data.category.CategoryRepository;
import com.codingz2m.plansservice.data.plan.Plan;


@Service
@Transactional 
public class CategoryServiceImpl  implements CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Plan getPlanByIdWithCategory(UUID categoryId) {
     	
		Optional<Category> category = categoryRepository.findById(categoryId);
				Category categoryObject = category.get();
				Plan plan =	categoryObject.retrievePlan();
		return plan;
	}

	

}
