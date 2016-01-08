package com.hzdp.review.filter.impl;

import java.util.List;

import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;
import com.hzdp.review.filter.ReviewCheckFilter;
import com.hzdp.review.filter.ReviewCheckFilterChain;

public class ReviewCheckFilterChainImpl implements ReviewCheckFilterChain {

	private List<ReviewCheckFilter> filters;

	public void setFilters(List<ReviewCheckFilter> filters) {
		this.filters = filters;
	}

	private int getLength() {
		return filters.size();
	}

	private ReviewCheckFilter get(int index) {
		return filters.get(index);
	}

	@Override
	public void dofilter(ReviewRequest request, ReviewResponse response) {
		new ReviewCheckFilterChain() {
			private int index = 0;

			@Override
			public void dofilter(ReviewRequest request, ReviewResponse response) {
				if (index < getLength()) {
					ReviewCheckFilter filter = get(index++);
					filter.filter(request, response, this);
				}
			}
		}.dofilter(request, response);
	}

}
