package com.registration.Registration.Controller;

import com.registration.Registration.Service.DonationService;
import com.registration.Registration.Entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping("/{barcode}/{userId}")
    public ResponseEntity<String> donateMedicine(@PathVariable String barcode,@PathVariable Long userId, @RequestBody Survey survey) {
        String result = donationService.checkEligibilityAndDonate(survey, barcode, userId);
        return ResponseEntity.ok(result);
    }
}
