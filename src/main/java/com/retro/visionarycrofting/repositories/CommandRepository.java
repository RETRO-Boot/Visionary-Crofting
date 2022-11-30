package com.retro.visionarycrofting.repositories;

import com.retro.visionarycrofting.entities.Client;
import com.retro.visionarycrofting.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommandRepository extends JpaRepository<Command, Long> {

}
