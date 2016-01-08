package com.hzdp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzdp.BaseTestCase;
import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;
import com.hzdp.review.service.ReviewService;

public class ReviewServiceTestCase extends BaseTestCase {

	@Autowired
	private ReviewService reviewService;

	@Test
	public void testAddReview() {
		ReviewRequest request = new ReviewRequest();
		request.setAge(12);
		request.setGrade(33);
		request.setInfo("sdfdkkl32ll32j3");
		request.setIp("255.255.255.255");
		request.setPlatform(1);
		request.setProductId(11);
		request.setProductType(2);
		request.setSkin(31);
		request.setUserId(3);
//		request.setCaptchaChecked(true);
		ReviewResponse response = reviewService.addReview(request);
		System.out.println(response.getResponseType());
	}

}
