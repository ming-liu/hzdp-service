package com.hzdp.review.filter.impl;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.hzdp.config.ConfigManager;
import com.hzdp.config.ConfigManagerLoader;
import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;
import com.hzdp.review.dao.ReviewDao;
import com.hzdp.review.filter.ReviewCheckFilter;
import com.hzdp.review.filter.ReviewCheckFilterChain;

public class RishControlFilter implements ReviewCheckFilter {

	private ConfigManager configManager = ConfigManagerLoader.getConfigManager();

	@Autowired
	private ReviewDao reviewDao;

	private int getCheckReviewThreshold() {
		return configManager.getIntValue("hzdp-service.review-check.threshold", 5);
	}

	private int getCheckReviewTimeSpan() {
		return configManager.getIntValue("hzdp-service.review-check.time-span", 60);
	}

	@Override
	public void filter(ReviewRequest request, ReviewResponse response, ReviewCheckFilterChain chain) {
		if (!request.isCaptchaChecked()) {
			int checkReviewTimeSpan = getCheckReviewTimeSpan();
			Date minAddTime = new Date(System.currentTimeMillis() - checkReviewTimeSpan * 1000);

			int checkReviewThreshold = getCheckReviewThreshold();
			int count = 0;
			try {
				count = reviewDao.count(request.getUserId(), minAddTime);
			} catch (SQLException e1) {
				// 如果出错，不做限制，防止无法评论。
			}
			if (count >= checkReviewThreshold) {
				response.setResponseType(ReviewResponse.ResponseTypeTooMuch);
				return;
			}
		}

		chain.dofilter(request, response);
	}

}
