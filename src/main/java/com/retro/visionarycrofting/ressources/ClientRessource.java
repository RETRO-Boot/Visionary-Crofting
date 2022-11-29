package com.retro.visionarycrofting.ressources;


import com.retro.visionarycrofting.entities.Client;
import com.retro.visionarycrofting.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Clients")
public class ClientRessource {

    private final ClientService clientService ;

    @Autowired
    public ClientRessource(ClientService clientService) {this.clientService = clientService;}

    @GetMapping
    public List<Client>  getClient(){ return clientService.getClient(); }

    @PostMapping
    public  Client addClient(Client client){return  clientService.addClient(client);}

    @DeleteMapping(path = "Client")
    public void  deleteById(@PathVariable("Client") long id){ clientService.deleteById(id);}

    @PutMapping(path = "{clientId}")
    public void  updateClient(
           @PathVariable("clientId") long id ,
           @RequestParam(required = false) String userName ,
           @RequestParam(required = false) String email,
           @RequestParam(required = false) String Tel,
           @RequestParam(required = false) String  password
    ){
        clientService.updateClient( id , userName , email , Tel , password);
    };
}
