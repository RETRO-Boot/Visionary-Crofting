package com.retro.visionarycrofting.ressources;


import com.retro.visionarycrofting.entities.Client;
import com.retro.visionarycrofting.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Clients")
public class ClientRessource {

    private final ClientService clientService ;

    @Autowired
    public ClientRessource(ClientService clientService) {this.clientService = clientService;}

    @GetMapping
    public List<Client>  getClient(){ return clientService.getClient(); }

    @PostMapping
    public  Client addClient(@RequestBody Client client){return  clientService.addClient(client);}

    @DeleteMapping(path = "Client/{id}")
    public String  deleteById(@PathVariable("id") long id){
        clientService.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping("/Clients/{id}")
    public Client updateClient(@RequestBody Client client , long id){
       return  clientService.updateClient(client,id);
    };

    @GetMapping(path = "Client/{id}")
    public Optional<Client> findById(@PathVariable long id){
        return clientService.findById(id) ;
    }
}
