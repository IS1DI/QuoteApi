package com.is1di.quoteapi.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record MessageBase(
        MessageMethod method,
        Object... args
) {
    @Getter
    @RequiredArgsConstructor
    public enum MessageMethod {
        USER_ERROR_NOT_FOUND("user.error.notFound"),
        QUOTE_NOT_FOUND("quote.error.notFound"),
        VOTE_NOT_FOUND("vote.error.notFound"),
        QUOTE_ACCESS_DENIED("quote.error.access");

        private final String message;

    }
}
