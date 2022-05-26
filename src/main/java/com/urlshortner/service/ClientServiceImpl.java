package com.urlshortner.service;

import com.urlshortner.Entity.Client;
import com.urlshortner.model.ClientRequest;
import com.urlshortner.repository.ClientRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientRequest createClient(ClientRequest clientRequest) {
      //  Client client = this.modelMapper.map(clientRequest, Client.class);

        Client client = Client.builder().host(clientRequest.getHost())
                .port(clientRequest.getPort())
                .name(clientRequest.getName())
                .expireAfterMillis(clientRequest.getExpireAfterMillis()).build();
        clientRepo.save(client);

        return this.modelMapper.map(client, ClientRequest.class);


    }





    @Override
    public ClientRequest updateClient(ClientRequest clientRequest, Long clientId) throws Exception {
        Client client = this.clientRepo.findById(clientId).orElseThrow(()->new Exception("client not found"));
        client.setName(clientRequest.getName());
        client.setHost(clientRequest.getHost());
        client.setPort(clientRequest.getPort());
        client.setExpireAfterMillis(clientRequest.getExpireAfterMillis());
        clientRepo.save(client);
        return this.modelMapper.map(client, ClientRequest.class);


    }

    @Override
    public void updateClient1(final Client client) {
        clientRepo.save(client);
    }

    @Override
    public ClientRequest getClientById(Long clientId) throws Exception {


        Client client = clientRepo.findById(clientId).orElseThrow(()->new Exception("Client Not Found"));
        return this.modelMapper.map(client, ClientRequest.class);
    }

    @Override
    public List<ClientRequest> getAllClient() {
        List<Client> clients = clientRepo.findAll();
        List<ClientRequest> clientRequests = clients.stream().map(client -> this.modelMapper.map(client, ClientRequest.class)).collect(Collectors.toList());

        return clientRequests;
    }
}
