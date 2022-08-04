package com.basicauthentication.sample.exception;

import lombok.Data;
import java.time.ZonedDateTime;

@Data
public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final ZonedDateTime zonedDateTime;

    public ApiException(String message, Throwable throwable,
                        ZonedDateTime zonedDateTime){
        this.message = message;
        this.throwable = throwable;
        this.zonedDateTime = zonedDateTime;
    }
}
