package com.hzdp.review.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.review.bean.ReviewRequest;
import com.hzdp.review.bean.ReviewResponse;
import com.hzdp.review.dao.ReviewDao;
import com.hzdp.review.entity.Review;
import com.hzdp.review.service.ReviewService;
import com.hzdp.util.CharUtils;
import com.hzdp.util.IPUtil;

@Service
public class ReviewServiceImpl implements ReviewService {

	protected Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ReviewDao reviewDao;

	@Override
	public ReviewResponse addReview(ReviewRequest request) {
		String ip = request.getIp();
		int grade = request.getGrade();
		int age = request.getAge();
		int productId = request.getProductId();
		int productType = request.getProductType();
		int skin = request.getSkin();
		String url = request.getUrl();
		int userId = request.getUserId();
		String info = request.getInfo();

		info = CharUtils.filterEmoticon(info);
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
		try {
			reviewDao.save(entity);
		} catch (SQLException e) {
			logger.error(e, e);
		}
		return null;
	}

}
