package com.retro.visionarycrofting.services.implementation;

import com.retro.visionarycrofting.entities.Fournisseur;
import com.retro.visionarycrofting.repositories.FournisseurRepository;
import com.retro.visionarycrofting.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class FournisseurServiceImp implements FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImp(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public List<Fournisseur> findAllFournisseur() {
        return  fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur findByName(String name) {
        Fournisseur fournisseur = fournisseurRepository.findByName(name);
        if(fournisseur != null){
            return fournisseur;
        }
        throw new IllegalStateException("Fournisseur with name "+name+" not exist");
    }

    @Override
    public Fournisseur findByEmail(String email) {
        Fournisseur fournisseur = fournisseurRepository.findByEmail(email);
        if(fournisseur != null){
            return fournisseur;
        }
        throw new IllegalStateException("Fournisseur with email: "+email+" not exist");
    }

    @Override
    public Fournisseur findById(Long id) {
        return fournisseurRepository.findById(id).
                orElseThrow(()->new IllegalStateException("Provider with id "+id+" not exist"));
    }

    @Override
    public Fournisseur addNewFournisseur(Fournisseur fournisseur) {
        if(fournisseur.getName()!=null && fournisseur.getEmail()!=null && fournisseur.getPhone()!=null && fournisseur.getPassword()!=null){
            return fournisseurRepository.save(fournisseur);
        }
        throw new IllegalStateException("One of the information is null");
    }

    @Override
    public void deleteFournisseur(Long id) {
        Fournisseur fournisseurToDelete = fournisseurRepository.findById(id)
                .orElseThrow(()->new IllegalStateException("This provider doesn't exist"));
            fournisseurRepository.delete(fournisseurToDelete);
    }

    @Override
    @Transactional
    public Fournisseur updateFournisseur(Fournisseur fournisseur , Long id) {
        Fournisseur fournisseurToUpdate = fournisseurRepository.findById(id).
                orElseThrow(()-> new IllegalStateException("This provider doesn't exist"));
        if (fournisseurToUpdate != null){
            if(fournisseur.getName()!=null ){
                fournisseurToUpdate.setName(fournisseur.getName());
            }
            if(fournisseur.getEmail()!=null ){
                fournisseurToUpdate.setEmail(fournisseur.getEmail());
            }
            if(fournisseur.getPhone()!=null ){
                fournisseurToUpdate.setPhone(fournisseur.getPhone());
            }
            if(fournisseur.getPassword()!=null ){
                fournisseurToUpdate.setPassword(fournisseur.getPassword());
            }
            return fournisseurToUpdate;
        }
        throw new IllegalStateException("This provider doesn't exist");
    }
}
