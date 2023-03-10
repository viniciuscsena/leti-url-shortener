package com.letiurl.letiurlshortener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.letiurl.letiurlshortener"})
@EnableScheduling
public class LetiUrlShortenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetiUrlShortenerApplication.class, args);
    }

    @Bean
    public Logger getLogger() {
        return LoggerFactory.getLogger("LetiLogger");
    }

}
