package com.is1di.quoteapi.exception;

import com.is1di.quoteapi.message.MessageBase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {
    private final MessageBase messageBase;
}
