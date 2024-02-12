package com.CK.repository;

import com.CK.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Optional<Appointment> findByDateAndTime(String date, String time);

    Optional<Appointment> findByAppointmentCode(String appointmentCode);

    Optional<Appointment> findByDoctorId(Long doctorId);
}
