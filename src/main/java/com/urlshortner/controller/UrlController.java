package com.urlshortner.controller;

import com.urlshortner.model.UrlRequest;
import com.urlshortner.model.UrlResponce;
import com.urlshortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping("/short_url")
    ResponseEntity getShortUrl(@RequestBody(required = true) UrlRequest urlRequest, @RequestHeader(value = "clientId", required = true) Long clientId) throws Exception {

            UrlResponce urlResponse = urlService.getShortUrl(urlRequest,clientId);
            return ResponseEntity.status(HttpStatus.OK).body(urlResponse);

    }

    @GetMapping("eId/{hash}")
    ResponseEntity getLongUrl(@PathVariable(required = true) String hash, @RequestHeader(value = "clientId", required = true) Long clientId) throws Exception {

            UrlResponce urlResponse = urlService.getLongUrl(hash,clientId);
            return ResponseEntity.status(HttpStatus.OK).body(urlResponse);

    }
}
