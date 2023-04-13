package com.example.product.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.example.product.Entities.Product;
import com.example.product.Entities.ProductImage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UploadImage {

  private final Cloudinary cloudinary;

  public Map<String, String> uploadProductImage(MultipartFile productImage) throws IOException {
    String public_id = UUID.randomUUID().toString();
    String imageUrl = cloudinary.uploader()
        .upload(productImage.getBytes(),
            Map.of("public_id", public_id, "folder", "ProductImage"))
        .get("secure_url").toString();
    Map<String, String> uploadInfo = new HashMap<String, String>();
    uploadInfo.put("public_id", public_id);
    uploadInfo.put("imageUrl", imageUrl);
    return uploadInfo;
  }

  public List<ProductImage> multiUploadProductImage(List<MultipartFile> productImage, Product product)
      throws IOException {
    List<ProductImage> uploadedProductImages = new ArrayList<ProductImage>();
    for (int i = 0; i < productImage.size(); i++) {
      if (productImage.get(i).isEmpty()) {
        throw new IOException();
      }
      Map<String, String> uploadInfo = uploadProductImage(productImage.get(i));
      uploadedProductImages.add(new ProductImage(uploadInfo.get("imageUrl"), uploadInfo.get("public_id"), product));
    }
    return uploadedProductImages;

  }
}
