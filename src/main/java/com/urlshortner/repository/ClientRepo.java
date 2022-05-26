package com.urlshortner.repository;

import com.urlshortner.Entity.Client;
import com.urlshortner.model.ClientRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long> {

  //  Client findByName(String name);

}
