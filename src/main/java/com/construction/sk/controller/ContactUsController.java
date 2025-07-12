package com.construction.sk.controller;

import com.construction.sk.entity.Contactus;
import com.construction.sk.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contactus")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

   
    // Handle form submission
    @PostMapping("/submit")
    public String submitMessage(@ModelAttribute("contactUs") Contactus contactUs, Model model) {
        contactUsService.saveMessage(contactUs);
        model.addAttribute("success", "Your message has been submitted successfully!");
        return "redirect:/SK/index"; // or redirect: return "redirect:/contact";
    }

    // (Optional) Show all messages (Admin View)
    @GetMapping("/all")
    public String viewAllMessages(Model model) {
        model.addAttribute("messages", contactUsService.getAllMessages());
        return "redirect:/admin/panel"; // Create contact-messages.html to show all entries
    }
}
