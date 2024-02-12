package com.CK.controller;

import com.CK.dto.request.DRegisterRequestDto;
import com.CK.dto.request.RegisterRequestDto;
import com.CK.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.CK.constants.RestApiUrls.*;

@RestController
@RequestMapping(DOCTOR)
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> register(@RequestBody DRegisterRequestDto dto){
        return ResponseEntity.ok(doctorService.register(dto));
    }
}
