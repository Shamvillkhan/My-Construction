package com.construction.sk.service;

import com.construction.sk.entity.Testimonial;
import com.construction.sk.filehandling.FileUploadUtil;
import com.construction.sk.repository.TestimonialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    public Testimonial saveTestimonial(Testimonial testimonial, MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            
            String savedFileName = FileUploadUtil.saveFile( imageFile);
            testimonial.setPhoto(savedFileName);
            testimonial.setImagePath(FileUploadUtil.UPLOAD_DIR + "/" + savedFileName);
        }

        testimonial.setCreatedAt(LocalDateTime.now());
        return testimonialRepository.save(testimonial);
    }

    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAll();
    }

    public void deleteById(Long id) {
        testimonialRepository.deleteById(id);
    }

    public Testimonial getById(Long id) {
        return testimonialRepository.findById(id).orElse(null);
    }
}
