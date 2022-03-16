package Internal.framework.controller.command;

import Internal.framework.module.commands.CommandInterface;

public class Invoker {
    private final CommandInterface[] commands = new CommandInterface[6];

    public void setCommand (int slot, CommandInterface command) {
        commands[slot] = command;
    }

    public CommandInterface getCommand(int slot) {
        return commands[slot];
    }
}
