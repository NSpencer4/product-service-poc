package com.productservicepoc.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserExistsExceptionTest {
    @Test
    void construct() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            throw new NotFoundException("message");
        });
    }
}