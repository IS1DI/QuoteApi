package com.is1di.quoteapi.service;

import com.is1di.quoteapi.exception.AccessDeniedException;
import com.is1di.quoteapi.exception.NotFoundException;
import com.is1di.quoteapi.message.MessageBase;
import com.is1di.quoteapi.model.entity.Quote;
import com.is1di.quoteapi.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

@Service
@Transactional
@RequiredArgsConstructor
public class QuoteService {
    private final QuoteRepository quoteRepository;
    private final UserService userService;

    public Quote create(Quote quote, String userLogin) {
        quote.setOwner(userService.getByLogin(userLogin));
        return quoteRepository.save(quote);
    }

    public Quote getById(UUID id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        new MessageBase(MessageBase.MessageMethod.QUOTE_NOT_FOUND)
                ));
    }

    public Quote getByIdAndUser(UUID quoteId, String userLogin) {
        Quote quote;
        if ((quote = getById(quoteId)).getOwner().getLogin().equals(userLogin)) {
            return quote;
        } else throw new AccessDeniedException(
                new MessageBase(MessageBase.MessageMethod.QUOTE_ACCESS_DENIED)
        );
    }

    public Quote getRandom() {
        return quoteRepository.findRandom()
                .orElseThrow(() -> new NotFoundException(
                        new MessageBase(MessageBase.MessageMethod.QUOTE_NOT_FOUND)
                ));
    }

    public <DTO> Quote update(UUID id, String userLogin, DTO dto, BiFunction<DTO, Quote, Quote> mapperToUpdate) {
        return quoteRepository.save(mapperToUpdate.apply(dto, getByIdAndUser(id, userLogin)));
    }

    public void delete(UUID id) {
        quoteRepository.delete(getById(id));
    }

    public List<Quote> findTopByVote(boolean isUpVoted) {
        return quoteRepository.findByVotesIsUpVoted(isUpVoted);
    }

    public Page<Quote> page(int page, int limit) {
        return quoteRepository.findAll(PageRequest.of(Math.max(page, 1) - 1, Math.max(limit, 1)));
    }
}
