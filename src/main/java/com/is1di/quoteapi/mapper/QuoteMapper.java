package com.is1di.quoteapi.mapper;

import com.is1di.quoteapi.model.dto.QuoteDto;
import com.is1di.quoteapi.model.entity.Quote;
import com.is1di.quoteapi.model.entity.Vote;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class QuoteMapper {
    public abstract Quote toEntity(QuoteDto.Create quote);

    @Mapping(target = "votesCount", qualifiedByName = "votesCount", source = "quote.votes")
    @Mapping(target = "upVotesCount", qualifiedByName = "upVotesCountMap", source = "quote.votes")
    @Mapping(target = "ownerLogin", source = "owner.login")
    public abstract QuoteDto.Output toOutput(Quote quote);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Quote toUpdate(QuoteDto.Update quoteToUpdate, @MappingTarget Quote quote);

    @Named("votesCount")
    public long votesCount(Set<Vote> voteSet) {
        if (voteSet != null) {
            return voteSet.size();
        }
        return 0;
    }

    @Named("upVotesCountMap")
    public long upVotesCountMap(Set<Vote> voteSet) {
        if (voteSet != null) {
            return voteSet.stream().filter(Vote::isUpVoted).count();
        }
        return 0;
    }
}
