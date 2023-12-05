package com.is1di.quoteapi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class ExceptionMessage {
    private final String message;
    private final LocalDateTime timeStamp;

    public ExceptionMessage(String message) {
        this.message = message;
        timeStamp = LocalDateTime.now();
    }
}
