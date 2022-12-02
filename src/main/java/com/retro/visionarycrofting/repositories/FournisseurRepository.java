package com.retro.visionarycrofting.repositories;
import com.retro.visionarycrofting.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    Fournisseur findByName(String name);

    Fournisseur findByEmail(String email);
}
