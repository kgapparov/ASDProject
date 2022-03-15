package Internal.framework.module;

public interface StateNotifyer {
    void register(Observer o);
    void remove(Observer o);
    void sendNotification(Account account, ActionType action);
}
