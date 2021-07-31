package com.codingz2m.actionmoviesservice.service.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz2m.actionmoviesservice.data.review.Review;
import com.codingz2m.actionmoviesservice.data.review.ReviewRepository;
import com.codingz2m.actionmoviesservice.shared.ReviewDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.UUID;


@Service
@Transactional 
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;

    @Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}
    
	@Override
	public Review createReviewWithMovieId(ReviewDto reviewDto) {
		 
		 ModelMapper modelMapper = new ModelMapper(); 
		  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		 Review review = modelMapper.map(reviewDto, Review.class);
		   review = reviewRepository.save(review);
		    
		return review;
	}
	
	@Override
	public int deleteReview(UUID reviewId) {
		int deleteReviewCount;
		deleteReviewCount = reviewRepository.deleteReview(reviewId);
		return deleteReviewCount;
	}


	@Override
	public Review getReviewByIdWithMovie(Long reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteReviewByIdFromMovie(Long reviewId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<ReviewDto> getReviews() {
		// TODO Auto-generated method stub
		return null;
	}


}

