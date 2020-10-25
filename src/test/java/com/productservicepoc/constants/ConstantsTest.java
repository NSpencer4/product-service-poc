package com.productservicepoc.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantsTest {

    @Test
    void testConstants() {
        assertEquals(Constants.NULL_ID_ERROR_CODE, "ERROR-0001");
        assertEquals(Constants.NULL_ID_ERROR_MESSAGE, "The ID passed in cannot be null.");
        assertEquals(Constants.USER_NOT_FOUND_ERROR_MESSAGE, "There is no user with the requested id.");
        assertEquals(Constants.USER_EXISTS_ERROR_MESSAGE, "There is already a user with the requested id.");
    }

}