package com.registration.Registration.Service;

import com.registration.Registration.Entity.Medicine;
import com.registration.Registration.Entity.Survey;
import com.registration.Registration.Entity.UserMedicine;
import com.registration.Registration.Repository.MedicineRepository;
import com.registration.Registration.Repository.SurveyRepository;
import com.registration.Registration.Repository.UserMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DonationService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserMedicineRepository userMedicineRepository;

    public String checkEligibilityAndDonate(Survey survey, String barcode, Long userId) {
        // Check if medicine exists in personal pharmacy of the user
        Optional<UserMedicine> userMedicineOpt = userMedicineRepository.findByUserIdAndMedicineBarcode(userId, barcode);

        if (!userMedicineOpt.isPresent()) {
            return "Medicine not found in your personal pharmacy.";
        }

        // Retrieve the medicine
        Medicine medicine = userMedicineOpt.get().getMedicine();

        // Check if it's a solid form (tablets or capsules)
        if (!medicine.getMedicine_type().equals("tablets") && !medicine.getMedicine_type().equals("capsules")) {
            return "Only solid oral dosage forms (tablets or capsules) are allowed.";
        }

        // Check if expiry date is more than 6 months away
        if (medicine.getExpiry_date().isBefore(LocalDate.now().plusMonths(6))) {
            return "Medicine must have more than 6 months of shelf life.";
        }

        // Check user-provided conditions
        if (survey.getTemperature() < 15 || survey.getTemperature() > 25) {
            return "Medicine must be stored between 15-25°C.";
        }

        if (!survey.isHumidityControlled()) {
            return "Medicine must be stored away from sunlight and moisture.";
        }

        if (!survey.isUnopenedSealed()) {
            return "Only unopened and sealed medicines can be donated.";
        }

        // If all conditions are met
        survey.setMedicine(medicine);
        survey.setEligibleForDonation(true);
        surveyRepository.save(survey);

        return "Medicine is eligible for donation!";
    }
}
