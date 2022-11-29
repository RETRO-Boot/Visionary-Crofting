package com.retro.visionarycrofting.repositories;

import com.retro.visionarycrofting.entities.CommandItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandItemRepository extends JpaRepository<CommandItem, Long> {

  Optional<CommandItem> findCommandItemByRef(String ref);
}
