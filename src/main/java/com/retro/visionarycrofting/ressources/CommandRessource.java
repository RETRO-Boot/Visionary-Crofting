package com.retro.visionarycrofting.ressources;

import com.retro.visionarycrofting.entities.Command;
import com.retro.visionarycrofting.services.CommandService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/commands")
public class CommandRessource {

    private final CommandService commandService;

    public CommandRessource(CommandService commandService) {
        this.commandService = commandService;
    }


    @GetMapping
    public List<Command>  getCommands(){
        return commandService.getCommands();
    }

    @PostMapping
    public  Command addCommand(@RequestBody Command command){
        return  commandService.AddCommand(command);
    }


    @DeleteMapping(path = "Commands/{id}")
    public String  deleteById(@PathVariable("id") Long id){
        commandService.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping(path = "Commands/{id}")
    public Command  updateCommend(@RequestBody Command command , long id){
        return commandService.updateCommend(command , id);
    };


}
