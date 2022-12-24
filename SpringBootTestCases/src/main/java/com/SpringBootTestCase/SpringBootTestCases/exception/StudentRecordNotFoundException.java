package com.SpringBootTestCase.SpringBootTestCases.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentRecordNotFoundException extends Exception {

    public StudentRecordNotFoundException(String msg) {
        super(msg);
    }

    public StudentRecordNotFoundException() {
        super();
    }
}
