package com.retro.visionarycrofting.services;

import com.retro.visionarycrofting.entities.CommandItem;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CommandItemService {
  List<CommandItem> getCommandItems();

  CommandItem addNew(CommandItem commandItem);

  void deleteById(Long id);

  void updateCommandItem(Long commandItemId, String commandItemRef, int commandItemQuantity, double price);
}
