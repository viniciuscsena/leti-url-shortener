package com.letiurl.letiurlshortener.controllers;

import com.letiurl.letiurlshortener.requests.ShortUrlRequest;
import com.letiurl.letiurlshortener.services.UrlShortenerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController("/")
@Api(value = "API to convert long url into short urls")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @ApiOperation(value = "Create short url", notes = "Create a short url from a long url")
    @PostMapping("/create")
    public ResponseEntity<?> createShortUrl(@RequestBody(required = true) ShortUrlRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(urlShortenerService.createShortUrl(request));
    }

    @ApiOperation(value = "Redirect", notes = "Redirect to the original url from the short url")
    @GetMapping("/{key}")
    public RedirectView redirect(@PathVariable String key) {

        String url = urlShortenerService.redirectUrl(key);
        return new RedirectView(url);
    }

}
