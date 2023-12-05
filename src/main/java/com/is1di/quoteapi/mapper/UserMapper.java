package com.is1di.quoteapi.mapper;

import com.is1di.quoteapi.model.dto.UserDto;
import com.is1di.quoteapi.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto.Output toOutput(User user);

    User toEntity(UserDto.Create user);
}
