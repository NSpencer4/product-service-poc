package com.productservicepoc.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BadRequestExceptionTest {
    @Test
    void construct() {
        Assertions.assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException("code", "message");
        });
    }
}