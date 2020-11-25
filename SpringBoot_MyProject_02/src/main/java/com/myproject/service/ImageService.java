package com.myproject.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.myproject.entity.EncodedImageEntity;

public interface ImageService {

	public void  saveFile(MultipartFile file) throws Exception;
	
	public String showImage(String name) throws Exception;
	
	public List<EncodedImageEntity> findAllImages();
	
}
