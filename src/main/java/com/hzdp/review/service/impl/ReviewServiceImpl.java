package com.hzdp.review.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.review.bean.ReviewListRequest;
import com.hzdp.review.bean.ReviewListResponse;
import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;
import com.hzdp.review.dao.ReviewDao;
import com.hzdp.review.entity.Review;
import com.hzdp.review.filter.ReviewCheckFilterChain;
import com.hzdp.review.service.ReviewService;
import com.hzdp.util.CharUtils;
import com.hzdp.util.IPUtil;

@Service
public class ReviewServiceImpl implements ReviewService {

	// private ConfigManager configManager =
	// ConfigManagerLoader.getConfigManager();
	protected Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private ReviewCheckFilterChain reviewCheckFilterChain;

	@Override
	public ReviewResponse addReview(ReviewRequest request) {
		ReviewResponse response = new ReviewResponse();
		int userId = request.getUserId();
		if (userId <= 0) {
			response.setResponseType(ReviewResponse.ResponseTypeLoginRequired);
			return response;
		}

		reviewCheckFilterChain.dofilter(request, response);
		if (!response.isSuccess()) {
			return response;
		}

		String ip = request.getIp();
		int grade = request.getGrade();
		int age = request.getAge();
		int productId = request.getProductId();
		int productType = request.getProductType();
		int skin = request.getSkin();

		String info = CharUtils.filterEmoticon(request.getInfo());
		info = CharUtils.replaceScriptTag(info);

		Review entity = new Review();
		entity.setReview(info);
		entity.setGrade1(grade);
		entity.setGrade2(0);
		entity.setGrade3(0);
		entity.setSkin(skin);
		entity.setAge(age);
		entity.setIp(IPUtil.toInt(ip));
		entity.setPlatform(request.getPlatform());
		entity.setReferId(productId);
		entity.setReferType(productType);
		entity.setStatus(1);
		entity.setUserId(userId);
		// entity.setUrls(urls.toString());
		try {
			int reviewId = reviewDao.save(entity);
			response.setReviewId(reviewId);
		} catch (SQLException e) {
			response.setResponseType(ReviewResponse.ResponseTypeFailed);
			logger.error(e, e);
		}
		return response;
	}

	@Override
	public ReviewListResponse pageReviews(ReviewListRequest request) {
		ReviewListResponse response = new ReviewListResponse();
		try {
			List<Review> reviewList = reviewDao.find(request.getProductId(), request.getProductType(), request.getReviewType(), request.getSkin(),
					request.getAge(), request.getOffset(), request.getPageSize());
			response.setReviewList(reviewList);
		} catch (SQLException e) {
			logger.error(e, e);
		}
		
		if(response.getReviewList() == null){
			response.setReviewList(new ArrayList<Review>());
		}
		return response;
	}

}
