package com.is1di.quoteapi.controller;

import com.is1di.quoteapi.mapper.VoteMapper;
import com.is1di.quoteapi.model.dto.VoteDto;
import com.is1di.quoteapi.model.dto.VoteDto.Output;
import com.is1di.quoteapi.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("vote")
public class VoteController {
    private final VoteMapper voteMapper;
    private final VoteService voteService;

}
