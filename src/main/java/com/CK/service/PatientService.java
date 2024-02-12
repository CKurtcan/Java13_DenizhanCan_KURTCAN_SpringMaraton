package com.CK.service;

import com.CK.dto.request.LoginRequestDto;
import com.CK.dto.request.RegisterRequestDto;
import com.CK.entity.Patient;
import com.CK.exception.ErrorType;
import com.CK.exception.HospitalException;
import com.CK.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Boolean register(RegisterRequestDto dto) {
        if (!dto.getPassword().equals(dto.getRePassword())){
            throw new HospitalException(ErrorType.UNMATCHED_PARAMETERS);
        }
        Patient patient = Patient.builder()
                .idNo(dto.getIdNo())
                .password(dto.getPassword())
                .rePassword(dto.getRePassword())
                .build();
        return true;
    }

    public Boolean login(LoginRequestDto dto) {
        Optional<Patient> authOptional = patientRepository.findOptionalByIdNoAndPassword(dto.getIdNo(),dto.getPassword());
        if(authOptional.isEmpty()){
            throw new HospitalException(ErrorType.LOGIN_ERROR);
        }
        return true;
    }
}
