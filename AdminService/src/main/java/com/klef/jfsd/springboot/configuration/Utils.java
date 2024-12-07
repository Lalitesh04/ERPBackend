package com.klef.jfsd.springboot.configuration;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class Utils {

    public static String encodeImage( MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "File is empty";
        }
        String fileType = file.getContentType();
        byte[] fileContent = file.getBytes();
        return "data:" + fileType + ";base64," + Base64.getEncoder().encodeToString(fileContent);
    }

}
