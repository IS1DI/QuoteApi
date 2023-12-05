package com.is1di.quoteapi.controller;

import com.is1di.quoteapi.mapper.VoteMapper;
import com.is1di.quoteapi.model.dto.VoteDto.Output;
import com.is1di.quoteapi.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("quote/{quoteId}/vote")
public class VoteByQuoteController {
    private final VoteService voteService;
    private final VoteMapper voteMapper;

    @PutMapping
    public Output vote(@PathVariable UUID quoteId, @RequestParam("user") String userLogin, @RequestParam("upvote") boolean isUpVote) {
        return voteMapper.toOutput(voteService.vote(quoteId, userLogin, isUpVote));
    }

    @GetMapping
    Page<Output> pageByUser(@PathVariable UUID quoteId,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                            @RequestParam(value = "user", required = false, defaultValue = "") String userLogin) {
        if (userLogin.isBlank()) {
            return voteService.getByQuote(quoteId, page, limit).map(voteMapper::toOutput);
        } else {
            return voteService.getByUserAndQuote(userLogin, quoteId, page, limit).map(voteMapper::toOutput);
        }
    }
}
