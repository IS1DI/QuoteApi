package com.is1di.quoteapi.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

public class UserDto {
    @Data
    public static final class Create {
        private String login;
        private String name;
        private String email;
        private String password;
    }

    @Data
    public static final class Output {
        private String login;
        private String name;
        private String email;
        private String password;
        private LocalDateTime createdAt;
    }
}
