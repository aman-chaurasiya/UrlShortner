package com.urlshortner.controller;

import com.urlshortner.Entity.Client;
import com.urlshortner.model.ClientRequest;
import com.urlshortner.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    ResponseEntity<ClientRequest> createClient(@RequestBody ClientRequest clientRequest) {
        ClientRequest client = clientService.createClient(clientRequest);

        return new ResponseEntity<ClientRequest>(client, HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    ResponseEntity<ClientRequest> updateClient(@RequestBody ClientRequest clientRequest, @PathVariable("clientId") Long clientId) throws Exception {

        ClientRequest updatedclient = this.clientService.updateClient(clientRequest, clientId);
        return new ResponseEntity<ClientRequest>(updatedclient, HttpStatus.OK);


    }

    @GetMapping("/")
    ResponseEntity<List<ClientRequest>> getAllClient(){
        List<ClientRequest> allClient = this.clientService.getAllClient();
        return new ResponseEntity<List<ClientRequest>>(allClient,HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    ResponseEntity<ClientRequest> getById(@PathVariable Long clientId) throws Exception{
        ClientRequest client = this.clientService.getClientById(clientId);
        return new ResponseEntity<ClientRequest>(client,HttpStatus.OK);

    }

}
