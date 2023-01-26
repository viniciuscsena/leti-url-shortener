package com.letiurl.letiurlshortener.services;

import com.letiurl.letiurlshortener.requests.RedirectRequest;

public interface UrlShortenerService {

    String redirectUrl(String key);
    String createShortUrl(RedirectRequest request );
}
