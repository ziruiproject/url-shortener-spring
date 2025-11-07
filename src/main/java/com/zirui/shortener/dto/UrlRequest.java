package com.zirui.shortener.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UrlRequest(
        @JsonProperty("original_url") String originalUrl,
        @JsonProperty("shortened_url") String shortenedUrl
) {}
