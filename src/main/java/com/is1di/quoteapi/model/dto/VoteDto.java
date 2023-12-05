package com.is1di.quoteapi.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

public class VoteDto {
    @Data
    public static final class Output {
        private UUID id;
        private String votedBy;
        private UUID quoteId;
        private LocalDateTime createdAt;
        private boolean isUpVoted;
    }
}
