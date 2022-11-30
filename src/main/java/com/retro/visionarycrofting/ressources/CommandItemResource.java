package com.retro.visionarycrofting.ressources;


import com.retro.visionarycrofting.entities.CommandItem;
import com.retro.visionarycrofting.entities.Product;
import com.retro.visionarycrofting.services.CommandItemService;
import com.retro.visionarycrofting.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/command-items")
public class CommandItemResource {
  private final CommandItemService commandItemService;
  private final ProductService productService;

  @Autowired
  public CommandItemResource(CommandItemService commandItemService, ProductService productService) {
    this.commandItemService = commandItemService;
    this.productService = productService;
  }

  @GetMapping
  public List<CommandItem> getCommandItems(){
    return commandItemService.getCommandItems();
  }

  @PostMapping
  public CommandItem addCommandItem(@RequestBody CommandItem commandItem){
    return commandItemService.addNew(commandItem);
  }


  @DeleteMapping(path = "{commandItemId}")
  public void deleteCommandItem(@PathVariable("commandItemId") Long id){
    commandItemService.deleteById(id);
  }

  @PutMapping(path = "{commandItemId}")
  public void updateCommandItem(
    @PathVariable("commandItemId") Long commandItemId,
    @RequestParam(required = false) String ref,
    @RequestParam(required = false) int quantity,
    @RequestParam(required = false) double price
  ){
    commandItemService.updateCommandItem(commandItemId, ref, quantity, price);
  }
}
