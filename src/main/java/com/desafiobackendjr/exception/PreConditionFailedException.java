package com.desafiobackendjr.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
public class PreConditionFailedException extends ServiceException {

    public PreConditionFailedException(String message) {
        super(message);
    }

    public PreConditionFailedException() {
        super("");
    }
}
