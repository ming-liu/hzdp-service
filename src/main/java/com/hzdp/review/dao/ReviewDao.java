package com.hzdp.review.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hzdp.dao.BaseDao;
import com.hzdp.review.entity.Review;

@Service
public class ReviewDao extends BaseDao {

	public int save(Review entity) throws SQLException {
		return (Integer) insert("Review.insert", entity);
	}

	public List<Review> find(int productId, int productType, int reviewType, int skin, int age, int offset, int pageSize) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("productId", productId);
		params.put("productType", productType);
		params.put("reviewType", reviewType);
		params.put("skin", skin);
		params.put("age", age);
		params.put("offset", offset);
		params.put("pageSize", pageSize);
		return queryList("Review.find", params);
	}

	public int count(int userId, Date minAddTime) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("minAddTime", minAddTime);
		Long count = (Long) queryObject("Review.count", params);
		return count.intValue();
	}
}
