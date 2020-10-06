package com.myproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.entity.PackageEntity;
import com.myproject.repository.PackageRepository;
import com.myproject.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService {

	private PackageRepository packageRepository;
	
	public PackageServiceImpl(PackageRepository packageRepository) {
		this.packageRepository = packageRepository;
	}

	@Override
	public List<PackageEntity> findPackages() {

		return packageRepository.findPackages();
	}

	@Override
	public List<PackageEntity> findPackagesBySpec(String html_page, String html_elements, String db, String search,
			String multilanguage, String animation, String auth, String newsletter) {

		return packageRepository.findPackagesBySpec(html_page, html_elements, db, search, multilanguage, animation, auth, newsletter);
	}
	
}
