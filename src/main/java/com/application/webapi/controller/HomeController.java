package com.application.webapi.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@ResponseBody
public class HomeController {
    
    @Autowired
    private CacheManager cacheManager;
    @GetMapping("/")
    public ResponseEntity<Object>  home(){
        Map<String, Object> response = new HashMap<>();
        response.put("APP_NAME", "Spring boot APP Redis Cache"); 
        return ResponseEntity.ok(response);
    }

    /* Hit this API for clear all cache in redis */
    @GetMapping("/clear-cache")
    public String clearCache() {
        cacheManager.getCacheNames().forEach(cacheName -> cacheManager.getCache(cacheName).clear());
        return "Cache Has clean.";
    }

}
