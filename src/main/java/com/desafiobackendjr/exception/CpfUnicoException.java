package com.desafiobackendjr.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
public class CpfUnicoException extends ServiceException {

    public CpfUnicoException(String message) {
        super(message);
    }

    public CpfUnicoException() {
        super("Já existe um Cliente cadastrado com este CPF");
    }
}
