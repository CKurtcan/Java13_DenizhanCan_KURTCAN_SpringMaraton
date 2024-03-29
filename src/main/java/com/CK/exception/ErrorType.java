package com.CK.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(1000, "Sunucuda beklenmeye hata oluştu, lütfen terar deneyiniz", HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_DUPLICATE_USERNAME(2000,"Bu Kullanıcı adı zaten kayıtlıdır. Lütfen değiştirerek tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_INVALID_LOGIN_PARAMETER(2001,"Kullanıcı adı ya da sifre hatalıdır. Lütfen tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    UNMATCHED_PARAMETERS(2002,"Girdiğiniz şifreler uyuşmuyor",HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4110,"Kullanici adi veya sifre hatalidir...",HttpStatus.BAD_REQUEST),
    APPOINTMENT_FULL(4141,"Almak istediğiniz saat ve tarihteki randevu doludur",HttpStatus.BAD_REQUEST),
    APPOINTMENT_NOT_FOUND(4142,"Randevu bulunamadı",HttpStatus.BAD_REQUEST),
    APPOINTMENT_NOT_AVAILABLE(4143,"Gösterilecek randevu mevcut değil",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(1001, "Girilen parametreler hatalıdır. Lütfen düzelterek tekrar deneyiniz", HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
}
