package com.vague.code_challenge.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageLocaleServiceImpl implements MessageLocaleService {
	
	@Autowired
    private MessageSource messageSource;

    public String getMessage(String id, String[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, new Object[] { args }, locale);
    }
    
    public String getMessage(String id, String args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, new Object[] { args }, locale);
    }
    
    public String getMessage(String id) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, null, locale);
    }
    
}
