package com.codingz2m.plansservice.service.plan;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz2m.plansservice.data.plan.Plan;
import com.codingz2m.plansservice.data.plan.PlanRepository;
import com.codingz2m.plansservice.shared.PlanDto;

@Service
@Transactional 
public class PlanServiceImpl implements PlanService {

	private PlanRepository planRepository;
	
	@Autowired
	public PlanServiceImpl(PlanRepository planRepository) {
		super();
		this.planRepository = planRepository;
	}


	@Override
	public Plan createPlanWithCategoryId(PlanDto planDto) {
		
		 ModelMapper modelMapper = new ModelMapper(); 
		  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		 Plan plan = modelMapper.map(planDto, Plan.class);
		   plan = planRepository.save(plan);
		    
		return plan;
	}
	

}
