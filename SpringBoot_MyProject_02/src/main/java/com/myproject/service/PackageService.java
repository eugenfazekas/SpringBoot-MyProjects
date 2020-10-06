package com.myproject.service;

import java.util.List;

import com.myproject.entity.PackageEntity;

public interface PackageService {
	
	public List<PackageEntity> findPackages();
	
	public List<PackageEntity> findPackagesBySpec(String html_page, String html_elements, String db, String search,
			String multilanguage, String animation, String auth, String newsletter);

}
