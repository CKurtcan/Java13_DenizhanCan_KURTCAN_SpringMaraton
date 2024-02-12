package com.CK.dto.response;


import com.CK.utility.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeAppointmentResponseDto {
    Long patientId;
    Long doctorId;
    String idNo;
    EStatus status;
    String date;
    String time;
}
