package com.myproject.repository;

import java.util.List;

import com.myproject.entity.PackageEntity;



public interface PackageRepository {
	
	public List<PackageEntity> findPackages();
	
	public List<PackageEntity> findPackagesBySpec(String html_page, String html_elements, String db, String search, String multilanguage, String animation, String auth, String newsletter);

}
