package com.registration.Registration.Service;

import com.registration.Registration.Entity.Medicine;
import com.registration.Registration.Entity.User;
import com.registration.Registration.Entity.UserMedicine;
import com.registration.Registration.Repository.MedicineRepository;
import com.registration.Registration.Repository.UserMedicineRepository;
import com.registration.Registration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonalPharmacyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private UserMedicineRepository userMedicineRepository;

    public String addMedicineToPersonalPharmacy(String phoneNumber, String barcode){
        // Find the user by phone number
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user == null) {
            return "User not found";
        }
        // Find the medicine by barcode
        Medicine medicine = medicineRepository.findByBarcode(barcode);
        if (medicine == null) {
            return "Medicine not found";
        }
        // Check if the medicine is expired
        if (medicine.getExpiry_date().isBefore(LocalDate.now())) {
            return "Medicine is expired";
        }
        // Add the medicine to the user's personal pharmacy
        UserMedicine userMedicine = new UserMedicine(user, medicine);
        userMedicineRepository.save(userMedicine);

        return "Medicine added to personal pharmacy";
    }
}
