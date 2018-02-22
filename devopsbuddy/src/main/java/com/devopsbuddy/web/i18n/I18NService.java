package com.devopsbuddy.web.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;
@Service
public class I18NService {

private static final Logger LOG= LoggerFactory.getLogger(I18NService.class);

    @Autowired
    MessageSource messageSource;

    public String getMessages(String messageId){
        LOG.info("Returning I18n Text for msg Id {}"+ messageId);
        Locale locale= LocaleContextHolder.getLocale();
        return  getMessages(messageId, locale);

    }

    public String getMessages(String messageId,Locale locale){
        return messageSource.getMessage(messageId,null,locale);

    }
}
