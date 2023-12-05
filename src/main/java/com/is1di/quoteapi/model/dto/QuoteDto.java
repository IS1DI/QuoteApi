package com.is1di.quoteapi.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.is1di.quoteapi.model.entity.Quote}
 */
public class QuoteDto {
    @Data
    public static final class Output {
        private UUID id;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String ownerLogin;
        private Long upVotesCount;
        private Long votesCount;
    }

    @Data
    public static final class Create {
        private String content;
    }

    @Data
    public static final class Update {
        private String content;
    }
}