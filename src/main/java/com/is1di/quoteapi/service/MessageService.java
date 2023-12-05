package com.is1di.quoteapi.service;

import com.is1di.quoteapi.message.MessageBase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@RequiredArgsConstructor
@Service
public class MessageService {
    private final MessageSource messageSource;

    public String getMessage(MessageBase messageBase) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(messageBase.method().getMessage(),messageBase.args(),locale);
    }
}
