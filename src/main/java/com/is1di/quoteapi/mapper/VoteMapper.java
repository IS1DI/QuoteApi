package com.is1di.quoteapi.mapper;

import com.is1di.quoteapi.model.dto.VoteDto;
import com.is1di.quoteapi.model.entity.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VoteMapper {
    @Mapping(target = "votedBy", source = "votedBy.login")
    @Mapping(target = "quoteId", source = "quote.id")
    VoteDto.Output toOutput(Vote vote);
}
