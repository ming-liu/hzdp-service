package com.hzdp.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hzdp.entity.Brand;

@Service
public class BrandDao extends BaseDao {

	public Brand find(int id) throws SQLException {
		return (Brand) queryObject("Brand.findById", id);
	}

	public List<Brand> findAll() throws SQLException {
		return queryList("Brand.findAll", null);
	}
}
