package com.is1di.quoteapi.service;

import com.is1di.quoteapi.model.entity.Quote;
import com.is1di.quoteapi.model.entity.User;
import com.is1di.quoteapi.model.entity.Vote;
import com.is1di.quoteapi.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class VoteService {
    private final VoteRepository voteRepository;
    private final QuoteService quoteService;
    private final UserService userService;

    public Vote vote(UUID quoteId, String userLogin, boolean isUpVoted) {
        User user = userService.getByLogin(userLogin);
        Quote quote = quoteService.getById(quoteId);
        Vote vote = new Vote();
        vote.setVotedBy(user);
        vote.setQuote(quote);
        vote.setUpVoted(isUpVoted);
        return voteRepository.save(vote);
    }

    public boolean existsByUserAndQuote(String userLogin, UUID quoteId) {
        return voteRepository.existsByVotedBy_LoginAndQuote_Id(userLogin, quoteId);
    }

    public Page<Vote> getByUserAndQuote(String userLogin, UUID quoteId, int page, int limit) {
        return voteRepository.findByVotedBy_LoginAndQuote_IdOrderByCreatedAtAsc(userLogin, quoteId, PageRequest.of(Math.max(page, 1) - 1, Math.max(limit, 1)));
    }

    public Page<Vote> getByQuote(UUID quoteId, int page, int limit) {
        return voteRepository.findByQuote_IdOrderByCreatedAtAsc(quoteId, PageRequest.of(page, limit));
    }
}
