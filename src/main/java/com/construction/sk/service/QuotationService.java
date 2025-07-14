package com.construction.sk.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.sk.entity.Quotation;
import com.construction.sk.entity.Users;
import com.construction.sk.repository.QuotationRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    public List<Quotation> getAllQuotations() {
        return quotationRepository.findAll();
    }

    public Optional<Quotation> getQuotationById(int id) {
        return quotationRepository.findById(id);
    }

//    public Quotation saveQuotation(Quotation quotation, Users user) {
//        quotation.setUser(user);
//
//        // User's input
//        BigDecimal userBudget = quotation.getEstimatedBudget();
//        String projectType = quotation.getProject();
//
//        // Step 1: Define minimum required base budget per project type
//        Map<String, BigDecimal> baseBudgetMap = Map.of(
//            "Office", new BigDecimal("500000"),
//            "Building", new BigDecimal("1000000"),
//            "House", new BigDecimal("400000"),
//            "Villa", new BigDecimal("800000"),
//            "Mansion", new BigDecimal("1500000"),
//            "Farmhouse", new BigDecimal("1200000")
//        );
//
//        // Step 2: Get base for this project
//        BigDecimal baseBudget = baseBudgetMap.getOrDefault(projectType, new BigDecimal("0"));
//
//        // Step 3: GST + Service Charge
//        BigDecimal gst = baseBudget.multiply(new BigDecimal("0.18"));
//        BigDecimal serviceCharge = new BigDecimal("500");
//        BigDecimal finalEstimated = baseBudget.add(gst).add(serviceCharge);
//
//        // Step 4: Compare user budget to required final cost
//        BigDecimal difference = userBudget.subtract(finalEstimated);
//
//        if (difference.compareTo(BigDecimal.ZERO) < 0) {
//            System.out.println("⚠️ Aapka budget kam hai. Kam se kam aur chahiye: ₹" + difference.abs());
//        } else if (difference.compareTo(BigDecimal.ZERO) > 0) {
//            System.out.println("✅ Aapka budget theek hai. ₹" + difference + " extra hai.");
//        } else {
//            System.out.println("🎯 Budget exactly fit hai.");
//        }
//
//        // Step 5: Save the final required budget (not user input)
//        quotation.setEstimatedBudget(finalEstimated);
//        quotation.setCreatedAt(LocalDateTime.now());
//
//    }


    public void deleteQuotation(int id) {
        quotationRepository.deleteById(id);
    }

    public List<Quotation> getQuotationsByUserId(int userId) {
        return quotationRepository.findByUserId(userId);
    }
}
