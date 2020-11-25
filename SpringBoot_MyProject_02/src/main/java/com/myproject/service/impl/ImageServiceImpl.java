package com.myproject.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.entity.EncodedImageEntity;
import com.myproject.entity.ImageEntity;
import com.myproject.repository.ImageRepository;
import com.myproject.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	
	private ImageRepository imageRepository;
	
	

	public ImageServiceImpl(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public void  saveFile(MultipartFile file) throws IOException  {
		
		 String pattern = "yyyy.MM.dd HH:mm:ss";
	     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		ImageEntity image = new ImageEntity();
		image.setName(file.getOriginalFilename());
		image.setData(file.getBytes());
		image.setPosted(simpleDateFormat.format(new Date()));
		imageRepository.save(image);
		
		}

	public List <EncodedImageEntity> findImagesByName(String name) {
	
		List<ImageEntity> entitys = imageRepository.findImagesByName(name);
		List<EncodedImageEntity> images = new ArrayList<EncodedImageEntity>();
		
		for(ImageEntity image : entitys) {
			
			EncodedImageEntity encodedImage = new EncodedImageEntity();
			byte[] encodeBase64 = Base64.encodeBase64(image.getData());
			try {
					encodedImage.setName(image.getName());	
					encodedImage.setEncodedData(new String(encodeBase64, "UTF-8"));
					encodedImage.setPosted(image.getPosted());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			images.add(encodedImage);
		}
		return images;
	}
		
	

	@Override
	public List<EncodedImageEntity> findAllImages() {
		
		List<ImageEntity> entitys = imageRepository.findAllImages();
		List<EncodedImageEntity> images = new ArrayList<EncodedImageEntity>();
		
		for(ImageEntity image : entitys) {
			
			EncodedImageEntity encodedImage = new EncodedImageEntity();
			byte[] encodeBase64 = Base64.encodeBase64(image.getData());
			try {
					encodedImage.setName(image.getName());	
					encodedImage.setEncodedData(new String(encodeBase64, "UTF-8"));
					encodedImage.setPosted(image.getPosted());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			images.add(encodedImage);
		}
		return images;
	}

	@Override
	public void deleteImage(String name) {
		
		imageRepository.deleteImage(name);
		
	}

	
}

//String folder = System.getProperty("user.dir")+"/src/main/resources/images/John/";
//System.out.println(folder);
//byte[] bytes = file.getBytes();
//Path path = Paths.get(folder + file.getOriginalFilename());
//Files.write(path,bytes);