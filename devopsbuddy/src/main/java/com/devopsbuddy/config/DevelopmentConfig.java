package com.devopsbuddy.config;


import com.devopsbuddy.backend.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/devopsbuddy-home/application-dev.properties")
public class DevelopmentConfig {


    @Bean
    public MockEmailService emailService(){
        return  new MockEmailService();
    }
}
