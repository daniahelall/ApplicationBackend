package com.registration.Registration.Repository;

import com.registration.Registration.Entity.UserMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMedicineRepository extends JpaRepository<UserMedicine, Long> {
    Optional<UserMedicine> findByUserIdAndMedicineBarcode(Long userId, String barcode);
}
