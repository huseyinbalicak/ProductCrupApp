package com.hsyn.balicak.productcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductRuntimeException extends RuntimeException {
    public ProductRuntimeException(String  message) {
        super(message);
    }
}
