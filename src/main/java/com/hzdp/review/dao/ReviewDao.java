package com.hzdp.review.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hzdp.dao.BaseDao;
import com.hzdp.review.entity.Review;

@Service
public class ReviewDao extends BaseDao {

	public int save(Review entity) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("po", entity);
		return (Integer) insert("Review.insert", params);
	}
}
