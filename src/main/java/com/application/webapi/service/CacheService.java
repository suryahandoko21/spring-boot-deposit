package com.application.webapi.service;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    private final CacheManager cacheManager;

    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void clearAllCaches() {
        cacheManager.getCacheNames().forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

}
