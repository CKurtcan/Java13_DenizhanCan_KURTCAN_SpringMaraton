package com.CK.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeAppointmentRequestDto {
    Long patientId;
    Long doctorId;
    String idNo;
    String name;
    String date;
    String time;
}
