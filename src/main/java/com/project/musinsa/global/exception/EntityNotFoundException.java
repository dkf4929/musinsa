package com.project.musinsa.global.exception;

import com.project.musinsa.global.enums.Errors;
import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private final Errors errors = Errors.ENTITY_NOT_FOUND;
    public EntityNotFoundException(String message) {
        super(message);
    }
}
