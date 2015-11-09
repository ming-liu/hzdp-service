package com.hzdp.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzdp.dao.BrandDao;
import com.hzdp.entity.Brand;
import com.hzdp.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	private Map<String, Brand> cache = new HashMap<String, Brand>();

	@Autowired
	private BrandDao brandDao;

	@Override
	public List<Brand> findAll() {
		List<Brand> brands = null;
		if (cache.isEmpty()) {
			brands = refreshCache();
		} else {
			brands = new ArrayList<Brand>(cache.values());
			Collections.sort(brands, new Comparator<Brand>() {
				@Override
				public int compare(Brand o1, Brand o2) {
					return o1.getId() - o2.getId();
				}
			});
		}

		if (brands == null) {
			brands = new ArrayList<Brand>();
		}

		return brands;
	}

	private List<Brand> refreshCache() {
		List<Brand> brands = null;
		try {
			cache.clear();
			brands = brandDao.findAll();
			for (Brand brand : brands) {
				cache.put(brand.getUrl(), brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brands;
	}

	@Override
	public Brand findByUrl(String url) {
		Brand brand = cache.get(url);
		if (brand == null) {
			refreshCache();
			brand = cache.get(url);
		}
		return brand;
	}

}
