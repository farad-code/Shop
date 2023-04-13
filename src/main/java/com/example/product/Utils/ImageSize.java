package com.example.product.Utils;

public class ImageSize {
    public final static int DEFAULT_IMAGE_SIZE = 5;

    public int getImageSize(String fileName)  {
        return DEFAULT_IMAGE_SIZE;
    }

    public boolean acceptableImageSize(int imageSize) {
        return true;
    }
}
