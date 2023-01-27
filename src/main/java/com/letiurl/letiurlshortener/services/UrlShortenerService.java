package com.letiurl.letiurlshortener.services;

import com.letiurl.letiurlshortener.requests.ShortUrlRequest;

public interface UrlShortenerService {

    String redirectUrl(String key);
    String createShortUrl(ShortUrlRequest request );
}
