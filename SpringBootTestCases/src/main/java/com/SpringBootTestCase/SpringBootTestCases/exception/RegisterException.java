package com.SpringBootTestCase.SpringBootTestCases.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegisterException extends Exception {
    public RegisterException(String msg) {
        super(msg);
    }

}
