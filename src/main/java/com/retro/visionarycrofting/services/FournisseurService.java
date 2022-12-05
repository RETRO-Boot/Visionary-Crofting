package com.retro.visionarycrofting.services;

import com.retro.visionarycrofting.entities.Fournisseur;
import com.retro.visionarycrofting.entities.Fournisseur;
import com.retro.visionarycrofting.entities.Fournisseur;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public interface FournisseurService {
    List<Fournisseur> findAllFournisseur();

    Fournisseur findByName(String name);

    Fournisseur findByEmail(String email);

    Fournisseur findById(Long id);

    Fournisseur addNewFournisseur(Fournisseur fournisseur);

    void deleteFournisseur(Long id);
    @Transactional
    Fournisseur updateFournisseur(Fournisseur fournisseur, Long id);
}
