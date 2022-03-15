package Internal.framework.module;

public interface CommandInterface {
    String getTitle();
    void setParams(String ...args);
    void execute();
}
