package com.is1di.quoteapi.exception;

import com.is1di.quoteapi.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {
    private final MessageService messageService;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessage notFound(NotFoundException ex) {
        return new ExceptionMessage(
                messageService.getMessage(ex.getMessageBase())
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionMessage accessDenied(AccessDeniedException ex) {
        return new ExceptionMessage(
                messageService.getMessage(ex.getMessageBase())
        );
    }
}
