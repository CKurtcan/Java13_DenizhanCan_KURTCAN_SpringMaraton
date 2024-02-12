package com.CK.repository;

import com.CK.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findOptionalByIdNoAndPassword(String idNo, String password);
}
