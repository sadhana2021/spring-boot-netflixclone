package com.codingz2m.trendingmoviesservice.service.review;

import java.util.UUID;

import com.codingz2m.trendingmoviesservice.data.review.Review;
import com.codingz2m.trendingmoviesservice.shared.ReviewDto;

public interface ReviewService {

	Review createReviewWithMovieId(ReviewDto reviewDto);
	
	Review getReviewByIdWithMovie(Long reviewId);
	
	int deleteReviewByIdFromMovie(Long reviewId);

	//	Product updateProductWithCategoryName(Long productId, ProductDto productDto);
	
	Iterable <ReviewDto> getReviews();
	
	int deleteReview (UUID reviewId);
	

}
