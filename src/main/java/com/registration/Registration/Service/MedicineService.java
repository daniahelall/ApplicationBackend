package com.registration.Registration.Service;

import com.registration.Registration.Entity.Medicine;
import com.registration.Registration.Repository.MedicineRepository;
import com.registration.Registration.Entity.MedicineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    public MedicineResponse getMedicineInfo(String barcode){
        Medicine medicine = medicineRepository.findByBarcode(barcode);

        if (medicine == null){
            return new MedicineResponse("Medicine not found", false, null);
        }

        boolean isExpired = medicine.getExpiry_date().isBefore(LocalDate.now());
        if (isExpired) {
            return new MedicineResponse("Medicine is expired", true, medicine);
        }

        return new MedicineResponse("Medicine found", false, medicine);
    }
}