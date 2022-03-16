package Internal.framework.controller.command;

public interface CommandInterface {
    String getTitle();
    void setParams(String ...args);
    void execute();
}
