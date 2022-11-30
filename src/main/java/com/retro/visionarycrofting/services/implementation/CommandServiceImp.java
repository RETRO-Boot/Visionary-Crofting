package com.retro.visionarycrofting.services.implementation;

import com.retro.visionarycrofting.entities.Command;
import com.retro.visionarycrofting.repositories.CommandRepository;
import com.retro.visionarycrofting.services.CommandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CommandServiceImp implements CommandService {

    private final CommandRepository commandRepository ;

    public CommandServiceImp(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }


    @Override
    public List<Command> getCommands() {
        return commandRepository.findAll();
    }

    @Override
    public Command AddCommand(Command command) {
        return commandRepository.save(command);
    }

    @Override
    public void deleteById(long id) {
        commandRepository.deleteById(id);
    }

    @Override
    public Command updateCommend(Command command , long id) {
        Command Cmd  = commandRepository.findById(id).get();

        if (Objects.nonNull(command.getRef())
                && !"".equalsIgnoreCase(command.getRef())
        ){
            Cmd.setRef(command.getRef());
        }

        if (Objects.nonNull(command.getDate())){
            Cmd.getDate();
        }


        if (Objects.nonNull(command.getPrixTotal())){
            Cmd.setPrixTotal(command.getPrixTotal());
        }

        return commandRepository.save(Cmd);
    }



}
