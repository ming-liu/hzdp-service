package com.hzdp.review.service;

import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;

public interface ReviewService {

	ReviewResponse addReview(ReviewRequest request);
}
