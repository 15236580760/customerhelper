package com.sun.exception;

import com.sun.enums.ResultEnum;

public class CustomerException extends RuntimeException {
    public CustomerException(String error) {
        super(error);
    }
}
