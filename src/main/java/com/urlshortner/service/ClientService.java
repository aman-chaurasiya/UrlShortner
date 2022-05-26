package com.urlshortner.service;

import com.urlshortner.Entity.Client;
import com.urlshortner.model.ClientRequest;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientRequest createClient(ClientRequest clientRequest);

    ClientRequest updateClient(ClientRequest clientRequest,Long clientId ) throws Exception;

    ClientRequest getClientById(Long clientId) throws Exception;

    void updateClient1(Client  client);

    List<ClientRequest> getAllClient();
}
