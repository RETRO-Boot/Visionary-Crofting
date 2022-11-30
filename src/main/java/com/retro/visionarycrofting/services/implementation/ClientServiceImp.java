package com.retro.visionarycrofting.services.implementation;

import com.retro.visionarycrofting.entities.Client;
import com.retro.visionarycrofting.repositories.ClientRepository;
import com.retro.visionarycrofting.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

import java.util.List;
import java.util.Optional;

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
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client client , long id){
        Client cli = clientRepository.findById(id).get();

        if (Objects.nonNull(client.getUserName())
                && !"".equalsIgnoreCase(client.getUserName())
        ){
            cli.setUserName(client.getUserName());
        }

        if (Objects.nonNull(client.getEmail())){
            cli.setEmail(client.getEmail());
        }


        if (Objects.nonNull(client.getTel())
                && !"".equalsIgnoreCase(client.getPassword())
        ){
            cli.setPassword(client.getPassword());
        }

        if (Objects.nonNull(client.getTel())){
            cli.setTel(client.getTel());
        }

        return clientRepository.save(cli);
    }

    @Override
    public Optional<Client> findById(long id) {
        return clientRepository.findById(id);
    }


}
