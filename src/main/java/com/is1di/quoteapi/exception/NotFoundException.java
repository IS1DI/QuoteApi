package com.is1di.quoteapi.exception;

import com.is1di.quoteapi.message.MessageBase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
    private final MessageBase messageBase;
}
