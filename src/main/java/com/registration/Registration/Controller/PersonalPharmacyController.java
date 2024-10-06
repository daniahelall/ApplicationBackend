package com.registration.Registration.Controller;

import com.registration.Registration.Service.PersonalPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personal-pharmacy")
public class PersonalPharmacyController {

    @Autowired
    private PersonalPharmacyService personalPharmacyService;

    @PostMapping("/add")
    public ResponseEntity<String> addMedicineToPharmacy(@RequestParam String phoneNumber, @RequestParam String barcode) {
        String result = personalPharmacyService.addMedicineToPersonalPharmacy(phoneNumber, barcode);
        if (result.equals("Medicine added to personal pharmacy")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
