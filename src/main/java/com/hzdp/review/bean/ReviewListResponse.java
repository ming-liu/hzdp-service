package com.hzdp.review.bean;

import java.io.Serializable;
import java.util.List;

import com.hzdp.review.entity.Review;

public class ReviewListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8108465024298208904L;

	private List<Review> reviewList;

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

}
