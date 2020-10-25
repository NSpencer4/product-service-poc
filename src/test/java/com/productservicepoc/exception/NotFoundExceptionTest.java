package com.productservicepoc.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NotFoundExceptionTest {
    @Test
    void construct() {
        Assertions.assertThrows(UserExistsException.class, () -> {
            throw new UserExistsException("message");
        });
    }
}