package com.CK.mapper;


import com.CK.dto.request.MakeAppointmentRequestDto;
import com.CK.dto.response.MakeAppointmentResponseDto;
import com.CK.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    Appointment fromMakeAppointmentRequestToAppointment(final MakeAppointmentRequestDto dto);
    MakeAppointmentResponseDto fromAppointmentToMakeAppointmentResponseDto(final Appointment appointment);
}
