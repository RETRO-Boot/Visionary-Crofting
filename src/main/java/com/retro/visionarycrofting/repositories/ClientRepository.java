package com.retro.visionarycrofting.repositories;

import com.retro.visionarycrofting.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Override
    Optional<Client> findById(Long id);

    Optional<Client> findClientByEmail(String email);
}
