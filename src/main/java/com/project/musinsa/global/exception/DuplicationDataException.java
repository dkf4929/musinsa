package com.project.musinsa.global.exception;

import com.project.musinsa.global.enums.Errors;
import lombok.Getter;

@Getter
public class DuplicationDataException extends RuntimeException {
    private final Errors errors = Errors.DUPLICATION_DATA;

    public DuplicationDataException(String message) {
        super(message);
    }
}
