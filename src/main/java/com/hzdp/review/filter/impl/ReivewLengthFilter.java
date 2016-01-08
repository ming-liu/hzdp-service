package com.hzdp.review.filter.impl;

import org.apache.commons.lang3.StringUtils;

import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;
import com.hzdp.review.filter.ReviewCheckFilter;
import com.hzdp.review.filter.ReviewCheckFilterChain;

public class ReivewLengthFilter implements ReviewCheckFilter {

	@Override
	public void filter(ReviewRequest request, ReviewResponse response, ReviewCheckFilterChain chain) {
		String info = request.getInfo().trim();
		if (StringUtils.isEmpty(info) || info.length() < 15) {
			response.setResponseType(ReviewResponse.ResponseTypeLengthDismatched);
			return;
		}
		chain.dofilter(request, response);
	}

}
