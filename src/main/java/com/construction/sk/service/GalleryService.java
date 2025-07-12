package com.construction.sk.service;

import com.construction.sk.entity.Gallery;
import com.construction.sk.repository.GalleryRepository;
import com.construction.sk.filehandling.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    public void saveGallery(MultipartFile file, String category,String title) throws IOException {
        String fileName = FileUploadUtil.saveFile(file);
        Gallery gallery = new Gallery();
        gallery.setTitle(title);
        gallery.setCategory(category);
        gallery.setImageName(fileName);
        gallery.setImagePath(FileUploadUtil.UPLOAD_DIR + "/" + fileName);
        galleryRepository.save(gallery);
    }

    public List<Gallery> getAllImages() {
        return galleryRepository.findAll();
    }

    public List<Gallery> searchByCategory(String keyword) {
        return galleryRepository.findByCategoryIgnoreCaseContaining(keyword);
    }
}
