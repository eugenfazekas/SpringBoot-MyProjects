package com.myproject.repository;

import java.util.List;

import com.myproject.entity.ImageEntity;

public interface ImageRepository {

	public void save (ImageEntity image);
	
	List <ImageEntity> findImagesByName(String name);
	
	List<ImageEntity> findAllImages();
	
	void deleteImage(String id);
	
}
