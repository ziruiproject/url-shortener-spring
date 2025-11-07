package com.zirui.shortener.repository;

import com.zirui.shortener.entity.Url;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Page<Url> findByOriginalUrl(String originalUrl, Pageable pageable);
    Optional<Url> findByShortenedUrl(String shortenedUrl);
}
