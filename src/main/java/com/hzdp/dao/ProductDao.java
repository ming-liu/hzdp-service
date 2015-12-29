package com.hzdp.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.hzdp.entity.Product;

@Service
public class ProductDao extends BaseDao {
	public Product findById(int id) throws SQLException {
		return (Product) queryObject("Product.findById", id);
	}
}
