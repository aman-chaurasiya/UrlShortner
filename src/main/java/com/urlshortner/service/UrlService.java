package com.urlshortner.service;

import com.urlshortner.model.UrlRequest;
import com.urlshortner.model.UrlResponce;

public interface UrlService {
     UrlResponce getShortUrl(UrlRequest urlRequest,Long clientId) throws Exception;
     UrlResponce getLongUrl(String encriptedId,Long clientId)throws Exception;
}
