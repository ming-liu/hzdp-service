package com.hzdp.service;

import java.util.List;

import com.hzdp.entity.Product;

public interface ProductService {
	Product findById(int productId);
	List<Product> findAll(String name, int offset, int pageSize);
}
