package com.construction.sk.controller;

import com.construction.sk.entity.Testimonial;
import com.construction.sk.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;
   

    @GetMapping
    public String viewAll(Model model) {
        List<Testimonial> list = testimonialService.getAllTestimonials();
        model.addAttribute("testimonials", list);
        return "testimonial/list"; // make testimonial/list.html
    }

    

    @PostMapping("/save")
    public String save(@ModelAttribute Testimonial testimonial,
                       @RequestParam("imageFile") MultipartFile file) throws IOException {
        testimonialService.saveTestimonial(testimonial, file);
        return "redirect:/SK/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        testimonialService.deleteById(id);
        return "redirect:/testimonials";
    }
}
