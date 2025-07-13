package com.construction.sk.filehandling;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileUploadUtil {
	public static final String UPLOAD_DIR="C:/Users/shamv/eclipse-workspace/sk/src/main/resources/static/image";

    public static String saveFile( MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file.");
        }

        // Create directory if it doesn't exist
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Generate unique file name
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uniqueFileName = System.currentTimeMillis() + "_" + originalFilename;
        // Save file
        Path filePath = Paths.get(UPLOAD_DIR, uniqueFileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
       

        return uniqueFileName; // Return the saved file name
    }
}
