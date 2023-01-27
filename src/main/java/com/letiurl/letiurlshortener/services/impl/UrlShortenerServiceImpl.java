package com.letiurl.letiurlshortener.services.impl;

import com.letiurl.letiurlshortener.entities.Url;
import com.letiurl.letiurlshortener.repositories.UrlRepository;
import com.letiurl.letiurlshortener.requests.ShortUrlRequest;
import com.letiurl.letiurlshortener.services.ConversionService;
import com.letiurl.letiurlshortener.services.UrlShortenerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {


    private final ConversionService conversionService;
    private final UrlRepository urlRepository;

    private final Logger logger;

    private static final String HTTPS = "https://";

    @Override
    public String createShortUrl(ShortUrlRequest request) {
        var url = new Url();

        if (!request.getLongUrl().contains(HTTPS))
            request.setLongUrl(HTTPS + request.getLongUrl());

        url.setLongUrl(request.getLongUrl());
        url.setCreationDate(LocalDateTime.now());
        url.setLastAccess(LocalDateTime.now());

        if (request.getKey() != null && !request.getKey().trim().isEmpty()) {
            Long id = conversionService.getIdFromString(request.getKey());
            urlRepository.findById(id).ifPresent(ur -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This key is already taken!");
            });
            url.setId(id);
            urlRepository.save(url);

            return request.getKey();
        }
        url = urlRepository.save(url);
        return conversionService.getStringFromId(url.getId());
    }

    @Override
    public String redirectUrl(String key) {
        Long id = conversionService.getIdFromString(key);
        Optional<Url> urlOptional = urlRepository.findById(id);
        if (urlOptional.isPresent()) {
            var url = urlOptional.get();
            logger.info("Url found.  Key: {} Id: {}", key, id);
            url.setLastAccess(LocalDateTime.now());
            urlRepository.save(url);
            return url.getLongUrl();
        }
        logger.info("No url found with the informed key {}", key);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "URL not found");
    }
}
