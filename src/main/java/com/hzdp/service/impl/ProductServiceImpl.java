package com.hzdp.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.dao.ProductDao;
import com.hzdp.entity.Product;
import com.hzdp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	protected Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ProductDao productDao;
	@Override
	public Product findById(int productId) {
		Product product = null;
		try {
			product = productDao.findById(productId);
		} catch (SQLException e) {
			logger.error("find product error!", e);
		}
		
		return product;
	}
}
