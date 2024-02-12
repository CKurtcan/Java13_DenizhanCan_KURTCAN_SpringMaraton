package com.CK.service;

import com.CK.dto.request.DRegisterRequestDto;
import com.CK.entity.Doctor;
import com.CK.exception.ErrorType;
import com.CK.exception.HospitalException;
import com.CK.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Boolean register(DRegisterRequestDto dto) {
        Doctor doctor = Doctor.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .branch(dto.getBranch())
                .title(dto.getTitle())
                .build();
        return true;
    }
}
