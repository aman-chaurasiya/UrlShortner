package com.urlshortner.service;

import com.urlshortner.Entity.Client;
import com.urlshortner.Entity.Url;
import com.urlshortner.model.ClientRequest;
import com.urlshortner.model.UrlRequest;
import com.urlshortner.model.UrlResponce;
import com.urlshortner.repository.ClientRepo;
import com.urlshortner.repository.UrlRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private UrlRepo urlRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UrlResponce getShortUrl(UrlRequest urlRequest, Long clientId) throws Exception {
        ClientRequest clientRequest = clientService.getClientById(clientId);
        Client client = this.modelMapper.map(clientRequest, Client.class);
        Url url = Url.builder().longUrl(urlRequest.getLongUrl()).build();
        url = urlRepo.save(url);
        client.getUrlList().add(url);

        clientService.updateClient1(client);

        Long id = url.getId();
        String encodedId = Base64.getEncoder().encodeToString(String.valueOf(id).getBytes());


        return UrlResponce.builder().url("http://" + client.getHost() + ":" + client.getPort() + "/" + encodedId).build();
    }

    @Override
    public UrlResponce getLongUrl(String encriptedId, Long clientId) throws Exception {

        String idString = new String(Base64.getDecoder().decode(encriptedId.getBytes(StandardCharsets.UTF_8)));
        Long id = Long.decode(idString);
        Url url = urlRepo.findById(id).orElseThrow(() -> new Exception("No url found"));


        return UrlResponce.builder().url(url.getLongUrl()).build();
    }
}
