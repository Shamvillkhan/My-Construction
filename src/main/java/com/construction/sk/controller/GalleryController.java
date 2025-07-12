package com.construction.sk.controller;

import com.construction.sk.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

   

    @PostMapping("/upload")
    public String handleUpload(@RequestParam("imageFile") MultipartFile file,
                               @RequestParam("category") String category,@RequestParam("title") String title) throws IOException {
        galleryService.saveGallery(file, category,title);
        return "admin/admin-index";
    }

   
}
