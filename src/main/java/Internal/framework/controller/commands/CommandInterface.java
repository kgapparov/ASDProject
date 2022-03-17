package Internal.framework.controller.commands;

public interface CommandInterface {
    String getTitle();
    void setParams(String ...args);
    void execute();
}
