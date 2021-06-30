package com.wow.myrpuniverse.exception;

import org.springframework.http.HttpStatus;

public class CursedException extends RuntimeException{
    public CursedException(String errorMessage, HttpStatus status) {
    }
}
