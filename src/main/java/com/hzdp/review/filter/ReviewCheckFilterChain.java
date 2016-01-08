package com.hzdp.review.filter;

import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;

public interface ReviewCheckFilterChain {

	void dofilter(ReviewRequest request, ReviewResponse response);
}
