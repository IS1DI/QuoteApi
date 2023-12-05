package com.is1di.quoteapi.controller;

import com.is1di.quoteapi.mapper.UserMapper;
import com.is1di.quoteapi.model.dto.UserDto;
import com.is1di.quoteapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto.Output create(UserDto.Create user) {
        return userMapper.toOutput(userService.create(userMapper.toEntity(user)));
    }
}
