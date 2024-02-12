package com.CK.exception;

import lombok.Getter;

@Getter
public class HospitalException extends RuntimeException{
    private final ErrorType errorType;
    public HospitalException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public HospitalException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
