package com.registration.Registration.Repository;

import com.registration.Registration.Entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
