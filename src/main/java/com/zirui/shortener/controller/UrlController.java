package com.zirui.shortener.controller;

import com.zirui.shortener.dto.UrlRequest;
import com.zirui.shortener.entity.Url;
import com.zirui.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("api/shorten")
    public ResponseEntity<Url> createUrl(@Validated @RequestBody UrlRequest urlRequest) {
        Url url = Url.builder()
                .originalUrl(urlRequest.originalUrl())
                .shortenedUrl(urlRequest.shortenedUrl())
                .build();
        Url result = urlService.save(url);
        return ResponseEntity.ok(result);
    }

    @GetMapping("api/urls")
    public ResponseEntity<Page<Url>> getUrls(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Url> urls = urlService.findAll(page, size);
        return ResponseEntity.ok(urls);
    }

    @GetMapping("/r/{shortenedUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String shortenedUrl) {
        return urlService.findByShortenedUrl(shortenedUrl)
                .map(url -> ResponseEntity.status(HttpStatus.FOUND)
                        .location(URI.create(url.getOriginalUrl()))
                        .<Void>build())
                .orElse(ResponseEntity.notFound().build());
    }
}
