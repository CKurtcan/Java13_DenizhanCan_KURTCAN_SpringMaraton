package com.CK.controller;

import com.CK.dto.request.LoginRequestDto;
import com.CK.dto.request.RegisterRequestDto;
import com.CK.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.CK.constants.RestApiUrls.*;

@RestController
@RequestMapping(PATIENT)
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    //önceden oluşturdupum için login ve register methodlarını silmedim koda ekstra bir etkisi yoktur

    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> register(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(patientService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(patientService.login(dto));
    }
}
