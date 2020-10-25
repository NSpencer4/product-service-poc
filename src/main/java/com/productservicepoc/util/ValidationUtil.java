package com.productservicepoc.util;

import com.productservicepoc.constants.Constants;
import com.productservicepoc.exception.BadRequestException;

public final class ValidationUtil {
    public static <T> void ensureRequestDataIsNotNull(T requestData) {
        if (requestData == null) {
            throw new BadRequestException(
                    Constants.NULL_ID_ERROR_CODE,
                    Constants.NULL_ID_ERROR_MESSAGE
            );
        }
    }
}
