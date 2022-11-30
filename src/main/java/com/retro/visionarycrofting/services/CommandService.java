package com.retro.visionarycrofting.services;

import com.retro.visionarycrofting.entities.Command;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CommandService {

    List<Command> getCommands();

    Command AddCommand(Command command);

    void  deleteById(long id);

    Command  updateCommend(Command command , long id);


}
