package com.is1di.quoteapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

public class UserDto {
    @Data
    @Schema(name = "user.create")
    public static final class Create {
        private String login;
        private String name;
        private String email;
        private String password;
    }

    @Data
    @Schema(name = "user.output")
    public static final class Output {
        private String login;
        private String name;
        private String email;
        private String password;
        private LocalDateTime createdAt;
    }
}
