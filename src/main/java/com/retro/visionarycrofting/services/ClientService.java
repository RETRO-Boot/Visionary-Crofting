package com.retro.visionarycrofting.services;

import com.retro.visionarycrofting.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService  {

    List<Client> getClient();

    Client addClient(Client client);

    void  deleteById(Long id);

    Client updateClient(Client client , long id);

}
