package com.hzdp.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.dao.BrandDao;
import com.hzdp.entity.Brand;
import com.hzdp.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public List<Brand> findAll() {
		List<Brand> brands = null;
		try {
			brands = brandDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (brands == null) {
			brands = new ArrayList<Brand>();
		}
		return brands;
	}

}
