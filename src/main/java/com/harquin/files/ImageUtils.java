package com.harquin.files;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageUtils {

	private static final Logger log = LoggerFactory.getLogger(ImageUtils.class);
	
	public static String getEncodedPhoto(String filename, String imageLocation, long maxFileSizeInKB)
    {
    	String encodedPhoto = null;
    	
    	//find photo
    	try
    	{
    		File photo = new File(imageLocation + filename);
    		
    		if(!photo.exists() || !photo.canRead())
    		{
    			log.warn("Image File Does Not Exist: " + photo.getAbsolutePath());
    			
    			return encodedPhoto;
    		}
    		
    		long fileSize = photo.length();
    		
    		long maxFileSize = maxFileSizeInKB * 1024L;
    		
    		if(fileSize > maxFileSize)
    		{
    			log.warn("Image Is Too Large: " + photo.getAbsolutePath());
    			return encodedPhoto;
    		}
    		
    		BufferedImage photoImage = ImageIO.read(photo);
    		
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( photoImage, FilenameUtils.getExtension(photo.getAbsolutePath()), baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();			
			
			encodedPhoto = new String(Base64.encodeBase64(imageInByte));
    	}
    	catch (Exception e)
    	{
    		log.error("Error Unable to Encode Image: ", e);
    	}
    	
    	return encodedPhoto;
    }
    
    public static void writeImageToDisk(String fileName, String imageLocation, String image)
    {	
    	String photoFileName = imageLocation + fileName;
    	
		File photoFile = new File(photoFileName);
		
		byte[] imageInBytes = Base64.decodeBase64(image);
		
		try
		{
			if(!photoFile.exists())
			{
				photoFile.createNewFile();
			}
			
			BufferedImage bfi = ImageIO.read(new ByteArrayInputStream(imageInBytes));
			
			ImageIO.write(bfi, FilenameUtils.getExtension(photoFileName), photoFile);
		}
		catch (Exception e)
		{
			log.error("Error Writing Image " + photoFileName + " To Disk For User: ", e);
		}
    }
}

