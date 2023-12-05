package com.is1di.quoteapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.is1di.quoteapi.model.entity.Quote}
 */
public class QuoteDto {
    @Data
    @Schema(name = "quote.output")
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
    @Schema(name = "quote.create")
    public static final class Create {
        private String content;
    }

    @Data
    @Schema(name = "quote.update")
    public static final class Update {
        private String content;
    }
}