package com.example.product.Utils;

import java.util.List;

public class MimeTypes {

    public static final String JPG = "image/jpeg";
    public static final String JPEG = "image/jpg";
    public static final String PNG = "image/png";
    public static final String GIF = "image/gif";

    List<String> mimeTypes = List.of(JPG, PNG, GIF, JPEG);

    public boolean AcceptedMimeType(String fileName) {
        return mimeTypes.contains(fileName);
    }
    
}
