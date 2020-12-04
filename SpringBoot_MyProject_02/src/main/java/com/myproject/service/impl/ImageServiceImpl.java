package com.myproject.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.entity.ImageEntity;
import com.myproject.repository.ImageRepository;
import com.myproject.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
		
	private ImageRepository imageRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public ImageServiceImpl(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	
	public void  saveFile(MultipartFile file) throws IOException  {
		
		 UUID uuid = UUID.randomUUID();
		
		 String pattern = "yyyy.MM.dd HH:mm:ss";
	     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
	     
		ImageEntity image = new ImageEntity();
		image.setId(uuid.toString());
		image.setName(file.getOriginalFilename());
		image.setPosted(simpleDateFormat.format(new Date()));
		imageRepository.save(image);
		
	    InputStream bis = file.getInputStream();
	    BufferedImage bImage2 = ImageIO.read(bis);
	    ImageIO.write(bImage2, "png", new File("src/main/resources/static/img/upload/"+ uuid+".png") );


		log.debug("Image Created: "+image.toString());
		}

	public List<ImageEntity> findImagesByName(String name) {
	
		List<ImageEntity> images = imageRepository.findImagesByName(name);

		
//		for(ImageEntity image : entitys) {
//			
//			EncodedImageEntity encodedImage = new EncodedImageEntity();
//			byte[] encodeBase64 = Base64.encodeBase64(image.getData());
//			try {
//					encodedImage.setName(image.getName());	
//					encodedImage.setEncodedData(new String(encodeBase64, "UTF-8"));
//					encodedImage.setPosted(image.getPosted());
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			images.add(encodedImage);
//		}
		return images;
	}
		
	

	@Override
	public List<ImageEntity> findAllImages() {
		
		List<ImageEntity> images = imageRepository.findAllImages();

		return images;
	}

	@Override
	public void deleteImage(String id) {
		
		String imageUrl = "src/main/resources/static/img/upload/"+ id +".png";

		File image = new File(imageUrl); 
		
		try {
			image.delete();
			imageRepository.deleteImage(id);
		}
		catch(Error e){
			System.out.println("Failed to delete file: "+e);
		}
	}

	
}

//String folder = System.getProperty("user.dir")+"/src/main/resources/images/John/";
//System.out.println(folder);
//byte[] bytes = file.getBytes();
//Path path = Paths.get(folder + file.getOriginalFilename());
//Files.write(path,bytes);