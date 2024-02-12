package com.CK.controller;

import com.CK.dto.request.CancelAppointmentRequestDto;
import com.CK.dto.request.MakeAppointmentRequestDto;
import com.CK.dto.response.MakeAppointmentResponseDto;
import com.CK.entity.Appointment;
import com.CK.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.CK.constants.RestApiUrls.*;

@RestController
@RequestMapping(APPOINTMENT)
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping(MAKE_APPOINTMENT)
    public ResponseEntity<MakeAppointmentResponseDto> makeAppointment(MakeAppointmentRequestDto dto){
        return ResponseEntity.ok(appointmentService.create(dto));
    }

    @PostMapping(CANCEL_APPOINTMENT)
    public ResponseEntity<Boolean> cancelAppointment(CancelAppointmentRequestDto dto){
        return ResponseEntity.ok(appointmentService.delete(dto));
    }

    @PutMapping(GET_ALL)
    public ResponseEntity<Optional<Appointment>> getAll(){
        return ResponseEntity.ok(appointmentService.findById(1L));
    }
}
