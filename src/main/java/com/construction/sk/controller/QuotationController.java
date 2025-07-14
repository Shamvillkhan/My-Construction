package com.construction.sk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.construction.sk.entity.Quotation;
import com.construction.sk.entity.Users;
import com.construction.sk.repository.UserRepository;
import com.construction.sk.service.ContactDetailService;
import com.construction.sk.service.QuotationService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quotations")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private ContactDetailService contactDetail;

  
    @GetMapping("/new")
    public String showCreateForm(Model model) {
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("<<<<<<"+username+">>>>>");
    	model.addAttribute("users",userRepo.findByUsername(username).get().getUsername());
    	model.addAttribute("quotation", new Quotation());
    	model.addAttribute("contactDetail",contactDetail.getActiveDetail());
        return "quotation-form"; // quotations/create.html
    }

    @PostMapping
    public String saveQuotation(@ModelAttribute Quotation quotation, Model model) {
        
        // ✅ Get logged-in user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        quotation.setUser(user);

        // ✅ User input
        BigDecimal userBudget = quotation.getEstimatedBudget();
        String projectType = quotation.getProject();

        // ✅ Step 1: Base Budget Mapping
        Map<String, BigDecimal> baseBudgetMap = Map.of(
            "Office", new BigDecimal("500000"),
            "Building", new BigDecimal("1000000"),
            "House", new BigDecimal("400000"),
            "Villa", new BigDecimal("800000"),
            "Mansion", new BigDecimal("1500000"),
            "Farmhouse", new BigDecimal("1200000")
        );

        BigDecimal baseBudget = baseBudgetMap.getOrDefault(projectType, BigDecimal.ZERO);

        // ✅ Step 2: GST and Charges
        BigDecimal gst = baseBudget.multiply(new BigDecimal("0.18"));
        BigDecimal serviceCharge = new BigDecimal("500");
        BigDecimal finalEstimated = baseBudget.add(gst).add(serviceCharge);

        // ✅ Step 3: Compare budget
        BigDecimal difference = userBudget.subtract(finalEstimated);
        String message;
        String budgetStatus;

        if (difference.compareTo(BigDecimal.ZERO) < 0) {
            message = "⚠️ Aapka budget ₹" + difference.abs() + " kam hai.";
            budgetStatus = "LOW";
        } else if (difference.compareTo(BigDecimal.ZERO) > 0) {
            message = "✅ Aapka budget theek hai. ₹" + difference + " extra hai.";
            budgetStatus = "EXTRA";
        } else {
            message = "🎯 Budget exactly fit hai.";
            budgetStatus = "OK";
        }

        // ✅ Save final estimated budget and time
        quotation.setEstimatedBudget(finalEstimated);
        quotation.setCreatedAt(LocalDateTime.now());
         

        // ✅ Add all summary data to model
        model.addAttribute("quotation", quotation);
        model.addAttribute("userBudget", userBudget);
        model.addAttribute("baseBudget", baseBudget);
        model.addAttribute("gst", gst);
        model.addAttribute("serviceCharge", serviceCharge);
        model.addAttribute("finalEstimated", finalEstimated);
        model.addAttribute("difference", difference);
        model.addAttribute("message", message);
        model.addAttribute("budgetStatus", budgetStatus);

        return "quotation"; // ⬅️ summary page (quotation.html)
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Quotation quotation = quotationService.getQuotationById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid quotation Id: " + id));
        model.addAttribute("quotation", quotation);
        return "quotations/edit"; // quotations/edit.html
    }

//    @PostMapping("/update/{id}")
//    public String updateQuotation(@PathVariable int id, @ModelAttribute Quotation quotation) {
//        quotation.setId(id);
//        quotationService.saveQuotation(quotation);
//        return "redirect:/quotations";
//    }

    @GetMapping("/delete/{id}")
    public String deleteQuotation(@PathVariable int id) {
        quotationService.deleteQuotation(id);
        return "redirect:/quotations";
    }
}
