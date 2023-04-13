package com.example.product.Configurations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {

   @Value("${cloudName}")
   private String CLOUD_NAME;
   @Value("${apiKey}")
   private  String API_KEY;
   @Value("${apiSecret}")
   private String API_SECRET ;
   private final static String RESOURCE_TYPE = "image";
   
  

 @Bean
  public Cloudinary cloudinary(){
     Map<String, String> config = new HashMap<>();
     config.put("cloud_name", CLOUD_NAME);
     config.put("api_key", API_KEY);
     config.put("api_secret", API_SECRET);
     config.put("secure", "true");
     config.put("resource_type", RESOURCE_TYPE);
      
     return new Cloudinary(config);
  }  

}
