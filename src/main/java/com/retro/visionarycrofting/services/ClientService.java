package com.retro.visionarycrofting.services;

import com.retro.visionarycrofting.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService  {

    List<Client> getClient();

    Client addClient(Client client);

    void  deleteById(Long id);

    void updateClient(long id , String userName , String email , String Tel , String password);

}
