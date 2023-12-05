package com.is1di.quoteapi.model.dto;

import lombok.Data;

public class UserDto {
    @Data
    public static final class Create {
        String login;
        String name;
        String email;
        String password;
    }
}
