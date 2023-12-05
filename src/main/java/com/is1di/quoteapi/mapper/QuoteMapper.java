package com.is1di.quoteapi.mapper;

import com.is1di.quoteapi.model.dto.QuoteDto;
import com.is1di.quoteapi.model.entity.Quote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuoteMapper {
    Quote toEntity(QuoteDto.Create quote);
    @Mapping(target = "votesCount", expression = "java(quote.getVotes().size())")
    @Mapping(target = "upVotesCount", expression = "java(quote.getVotes().stream().filter(com.is1di.quoteapi.model.entity.Vote::isUpVoted).count())")
    @Mapping(target = "ownerLogin", source = "owner.login")
    QuoteDto.Output toOutput(Quote quote);
    Quote toUpdate(QuoteDto.Update quoteToUpdate, Quote quote);
}
