package com.hzdp.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hzdp.entity.Product;

@Service
public class ProductDao extends BaseDao {
	public Product findById(int id) throws SQLException {
		return (Product) queryObject("Product.findById", id);
	}
	public List<Product> findAll(String name, int offset, int pageSize) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("offset", offset);
		params.put("pageSize", pageSize);
		return queryList("Product.findAll", params);
	}
}
