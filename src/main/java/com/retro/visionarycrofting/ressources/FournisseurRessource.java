package com.retro.visionarycrofting.ressources;

import com.retro.visionarycrofting.entities.CallForProposal;
import com.retro.visionarycrofting.entities.Fournisseur;
import com.retro.visionarycrofting.enumeration.CallForProposalStatus;
import com.retro.visionarycrofting.services.FournisseurService;
import com.retro.visionarycrofting.services.implementation.FournisseurServiceImp;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "fournisseur")
public class FournisseurRessource {
    @Autowired
    FournisseurService fournisseurService;


    @PostMapping
    public Fournisseur addNewFournisseur(@RequestBody Fournisseur fournisseur){ return fournisseurService.addNewFournisseur(fournisseur);}
    @GetMapping
    public List<Fournisseur> findAllFournisseur(){ return fournisseurService.findAllFournisseur();}
    @GetMapping("/{name}")
    public Fournisseur findByName(@PathVariable String name){ return fournisseurService.findByName(name);}
    @GetMapping("/email/{email}")
    public Fournisseur findByEmail(@PathVariable String email){ return fournisseurService.findByEmail(email);}
    @PutMapping
    public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur, @RequestParam(value = "id", defaultValue = "") Long id){ return fournisseurService.updateFournisseur(fournisseur, id);}
    @DeleteMapping
    void deleteFournisseur(@RequestParam(value = "id", defaultValue = "") Long id){ fournisseurService.deleteFournisseur(id);}
    @GetMapping("/callForProposal/{status}")
    public List<Object> findAllOpenCallForProposal(@PathVariable String status, @RequestParam(value = "name", defaultValue = "null")String name){
        if (status.equalsIgnoreCase("open")){
            String url = "http://localhost:9090/api/v1/call-for-proposal/status/open";
            RestTemplate restTemplate = new RestTemplate();
            Object[] openCallForProposal = restTemplate.getForObject(url, Object[].class);
            return Arrays.asList(openCallForProposal);
        }
        else if (status.equalsIgnoreCase("confirmed")){
            if(!name.equals("null")){
                String url = "http://localhost:9090/api/v1/call-for-proposal/frs?name="+name;
                RestTemplate restTemplate = new RestTemplate();
                Object[] confirmedCallForProposal = restTemplate.getForObject(url, Object[].class);
                return Arrays.asList(confirmedCallForProposal);
            }throw new IllegalStateException("You must set a name");
        }
        throw new IllegalStateException("Status not valid");
    }

    @PutMapping("/callForProposal/open/{c_f_p_id}")
    public Object confirmeCallForProposal(@RequestBody CallForProposal callForProposal,@PathVariable Long c_f_p_id, @RequestParam(value = "name", defaultValue = "null")String name){
        Fournisseur fournisseur;
        if (c_f_p_id!=null){
            callForProposal.setId(c_f_p_id);
            if (!name.equals("null")){
                fournisseur = fournisseurService.findByName(name);
                callForProposal.setFournisseur(fournisseur);
                callForProposal.setStatus(CallForProposalStatus.valueOf("confirmed"));
                String url = "http://localhost:9090/api/v1/call-for-proposal/update";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.put(url, callForProposal, CallForProposal.class);
                return "success";
            }else throw new IllegalStateException("The name cannot be null");
        }else throw new IllegalStateException("Call for proposal Id cannot be null");

    }
    @GetMapping(value = "/test")
    Object test(@RequestParam (value="int", defaultValue = "1")int intt){
        if (intt > 2) {
            return 2;
        }
        throw new IllegalStateException("Integer not found");
    }


}
