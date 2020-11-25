package com.myproject.repository;

import java.util.List;

import com.myproject.entity.ImageEntity;

public interface ImageRepository {

	public void save (ImageEntity image);
	
	public ImageEntity findByName(String name);
	
	List<ImageEntity> findAllImages();
}
