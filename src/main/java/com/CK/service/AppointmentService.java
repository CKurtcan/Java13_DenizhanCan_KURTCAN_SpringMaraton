package com.CK.service;

import com.CK.dto.request.CancelAppointmentRequestDto;
import com.CK.dto.request.MakeAppointmentRequestDto;
import com.CK.dto.response.MakeAppointmentResponseDto;
import com.CK.entity.Appointment;
import com.CK.entity.Doctor;
import com.CK.exception.ErrorType;
import com.CK.exception.HospitalException;
import com.CK.mapper.AppointmentMapper;
import com.CK.repository.AppointmentRepository;
import com.CK.repository.PatientRepository;
import com.CK.utility.CodeGenerator;
import com.CK.utility.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public MakeAppointmentResponseDto create(MakeAppointmentRequestDto dto) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findByDateAndTime(dto.getDate(),dto.getTime());
        if (optionalAppointment.isEmpty()) {
            throw new HospitalException(ErrorType.APPOINTMENT_NOT_FOUND);
        }
        if (optionalAppointment.get().getStatus().equals(EStatus.FULL)){
            throw new HospitalException(ErrorType.APPOINTMENT_FULL);
        }
        Appointment appointment = AppointmentMapper.INSTANCE.fromMakeAppointmentRequestToAppointment(dto);
        appointment.setAppointmentCode(CodeGenerator.generateCode());
        appointment.setStatus(EStatus.FULL);
        appointmentRepository.save(appointment);
        return AppointmentMapper.INSTANCE.fromAppointmentToMakeAppointmentResponseDto(appointment);
    }

    public Boolean delete(CancelAppointmentRequestDto dto) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findByAppointmentCode(dto.getAppointmentCode());
        if (optionalAppointment.isEmpty()){
            throw new HospitalException(ErrorType.APPOINTMENT_NOT_FOUND);
        }
        Appointment appointment = optionalAppointment.get();
        appointment.setIdNo(null);
        appointment.setPatientId(null);
        appointment.setAppointmentCode(null);
        appointment.setStatus(EStatus.EMPTY);
        appointmentRepository.delete(appointment);
        return true;
    }

    public Optional<Appointment> findById(Long doctorId) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findByDoctorId(doctorId);
        if (appointmentOptional.isEmpty()){
            throw new HospitalException(ErrorType.APPOINTMENT_NOT_AVAILABLE);
    }
        return appointmentRepository.findByDoctorId(doctorId);
    }
}
