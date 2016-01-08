package com.hzdp.review.filter;

import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;

public interface ReviewCheckFilter {

	void filter(ReviewRequest request, ReviewResponse response, ReviewCheckFilterChain chain);

}
