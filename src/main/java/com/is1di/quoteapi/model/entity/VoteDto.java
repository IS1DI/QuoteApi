package com.is1di.quoteapi.model.entity;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link Vote}
 */
@Value
public class VoteDto implements Serializable {
    UUID id;
    String votedByLogin;
    UUID quoteId;
    LocalDateTime createdAt;
    boolean isUpVoted;
}