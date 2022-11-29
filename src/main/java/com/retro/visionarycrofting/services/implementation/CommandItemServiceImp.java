package com.retro.visionarycrofting.services.implementation;

import com.retro.visionarycrofting.entities.CommandItem;
import com.retro.visionarycrofting.repositories.CommandItemRepository;
import com.retro.visionarycrofting.services.CommandItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommandItemServiceImp implements CommandItemService {

  private final CommandItemRepository commandItemRepository;

  @Autowired
  public CommandItemServiceImp(CommandItemRepository commandItemRepository) {
    this.commandItemRepository = commandItemRepository;
  }

  @Override
  public List<CommandItem> getCommandItems() {
    return commandItemRepository.findAll();
  }

  @Override
  public CommandItem addNew(CommandItem commandItem) {
    Optional<CommandItem> commandItemOptional = commandItemRepository.findCommandItemByRef(commandItem.getRef());
    if (commandItemOptional.isPresent()){
      throw new IllegalStateException("Command Item with this reference already exist");
    }
    return commandItemRepository.save(commandItem);
  }

  @Override
  public void deleteById(Long id) {
    if (!commandItemRepository.existsById(id)){
      throw new IllegalStateException("Command Item with id " + id + " doesn't exist");
    }
    commandItemRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void updateCommandItem(Long commandItemId, String commandItemRef, int commandItemQuantity, double prix) {
    CommandItem commandItemToUpdate = commandItemRepository.findById(commandItemId).
      orElseThrow(() -> new IllegalStateException("Command Item with id " + commandItemId + " doesn't exist"));

    // Updating reference:
    if (commandItemRef != null && commandItemRef.length() > 0 && !Objects.equals(commandItemToUpdate.getRef(), commandItemRef)){
      Optional<CommandItem> commandItemOptional = commandItemRepository.findCommandItemByRef(commandItemRef);
      if (commandItemOptional.isPresent()){
        throw new IllegalStateException("this reference already exist");
      }
      commandItemToUpdate.setRef(commandItemRef);
    }

    if (Integer.valueOf(commandItemQuantity) != null){
      commandItemToUpdate.setQuantite(commandItemQuantity);
    }
    if (Double.valueOf(prix) != null){
      commandItemToUpdate.setPrix(prix);
    }
  }
}
