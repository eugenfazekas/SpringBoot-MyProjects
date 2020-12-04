package com.myproject.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.myproject.entity.ImageEntity;

public interface ImageService {

	public void  saveFile(MultipartFile file) throws Exception;
	
	public List <ImageEntity> findImagesByName(String name) throws Exception;
	
	public List<ImageEntity> findAllImages();
	
	public void deleteImage(String id);
	
}
