package com.retro.visionarycrofting.services.implementation;

import com.retro.visionarycrofting.entities.Client;
import com.retro.visionarycrofting.repositories.ClientRepository;
import com.retro.visionarycrofting.repositories.CommandItemRepository;
import com.retro.visionarycrofting.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getClient(){
        return clientRepository.findAll();
    };

    @Override
    public Client addClient(Client client) {
        return null;
    }

    @Override
    public void deleteById(Long id){

    }

    @Override
    public void updateClient(long id , String userName , String email , String Tel , String password){

    }

}
