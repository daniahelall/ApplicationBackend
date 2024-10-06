package com.registration.Registration.Controller;

import com.registration.Registration.Entity.MedicineResponse;
import com.registration.Registration.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/{barcode}")
    public ResponseEntity<?> getMedicine(@PathVariable String barcode){
        MedicineResponse response = medicineService.getMedicineInfo(barcode);
        if (response.getMedicine() == null){
            return ResponseEntity.status(404).body(response);
        }
        if (response.isExpired()) {
            return ResponseEntity.status(400).body(response); // Expired medicine
        }

        return ResponseEntity.ok(response); // Medicine found and not expired
    }
}