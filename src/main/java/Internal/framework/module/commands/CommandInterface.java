package Internal.framework.module.commands;

public interface CommandInterface {
    String getTitle();
    void setParams(String ...args);
    void execute();
}
