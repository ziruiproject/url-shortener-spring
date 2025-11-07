package com.zirui.shortener.service;

import com.zirui.shortener.entity.Url;
import com.zirui.shortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
    @Autowired
    public UrlRepository urlRepository;

    public Page<Url> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return urlRepository.findAll(pageable);
    }

    public Optional<Url> findById(Long id){
        return urlRepository.findById(id);
    }

    public Optional<Url> findByShortenedUrl(String url) {
        return urlRepository.findByShortenedUrl(url);
    }

    public Url save(Url url) {
        return urlRepository.save(url);
    }

}
