package com.is1di.quoteapi.controller;

import com.is1di.quoteapi.mapper.QuoteMapper;
import com.is1di.quoteapi.model.dto.QuoteDto;
import com.is1di.quoteapi.model.dto.QuoteDto.Create;
import com.is1di.quoteapi.model.dto.QuoteDto.Output;
import com.is1di.quoteapi.model.dto.QuoteDto.Update;
import com.is1di.quoteapi.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("quote")
public class QuoteController {
    private final QuoteService quoteService;
    private final QuoteMapper quoteMapper;

    @PostMapping
    public Output create(@RequestBody Create quote, String userLogin) {
        return quoteMapper.toOutput(quoteService.create(quoteMapper.toEntity(quote),userLogin));
    }

    @GetMapping
    public Page<Output> page(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                             @RequestParam(value = "limit",required = false,defaultValue = "10") int limit) {
        return quoteService.page(page,limit).map(quoteMapper::toOutput);
    }

    @GetMapping("rand")
    public Output random() {
        return quoteMapper.toOutput(quoteService.getRandom());
    }

    @PutMapping("{id}")
    public Output update(@PathVariable UUID id, @RequestBody Update quote) {
        return quoteMapper.toOutput(quoteService.update(id, quote, quoteMapper::toUpdate));
    }

    @GetMapping("{id}")
    public Output getById(@PathVariable UUID id) {
        return quoteMapper.toOutput(quoteService.getById(id));
    }

    @GetMapping("top")
    public List<Output> getTop10(@RequestParam("upvote") boolean isUpVoted) {
        return quoteService.findTopByVote(isUpVoted).stream().map(quoteMapper::toOutput).collect(Collectors.toList());
    }
}
