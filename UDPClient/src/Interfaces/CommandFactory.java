package Interfaces;

import Commands.Command;

public interface CommandFactory {
    public Command chooseCommand(String commandLine);
}
