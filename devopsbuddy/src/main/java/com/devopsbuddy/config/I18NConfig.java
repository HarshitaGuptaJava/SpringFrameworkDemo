package com.devopsbuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class I18NConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){

        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource=new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setCacheSeconds(1800);
        reloadableResourceBundleMessageSource.setBasename("classpath:i18n/messages");
        return  reloadableResourceBundleMessageSource;
    }
}
