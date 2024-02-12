package com.CK.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DRegisterRequestDto {
    String name;
    String surname;
    String branch;
    String title;
}
