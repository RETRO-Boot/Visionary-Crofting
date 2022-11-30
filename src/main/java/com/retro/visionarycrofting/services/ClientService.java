package com.retro.visionarycrofting.services;

import com.retro.visionarycrofting.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService  {

    List<Client> getClient();

    Client addClient(Client client);

    void  deleteById(Long id);

    Client updateClient(Client client , long id);

    Optional<Client> findById(long id);

    Optional<Client>  findClientByEmail(String email);

}
