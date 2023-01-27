package com.letiurl.letiurlshortener.scheduler;

import com.letiurl.letiurlshortener.repositories.UrlRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Period;

@AllArgsConstructor
@Component
public class DeleteInvalidUrlsScheduler {

    private final UrlRepository repository;
    private final Logger logger;

    @Scheduled(cron = "0 12 * * * ?")
    public void deleteInvalidUrls(){
        logger.info("Deleting all not accessed urls for 15 days");
        repository.deleteAllNotAccessedSince(LocalDateTime.now().minus(Period.of(0, 0, 15)));
    }

}
