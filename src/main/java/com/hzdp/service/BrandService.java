package com.hzdp.service;

import java.util.List;

import com.hzdp.entity.Brand;

public interface BrandService {

	List<Brand> findAll();
	
	Brand findByUrl(String url);
}
