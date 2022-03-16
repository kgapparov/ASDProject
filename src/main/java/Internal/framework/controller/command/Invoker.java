package Internal.framework.controller.command;

public class Invoker {
    private final CommandInterface[] commands = new CommandInterface[5];

    public void setCommand (int slot, CommandInterface command) {
        commands[slot] = command;
    }

    public CommandInterface getCommand(int slot) {
        return commands[slot];
    }
}
