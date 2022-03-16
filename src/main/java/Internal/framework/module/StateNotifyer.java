package Internal.framework.module;

public interface StateNotifyer {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void sendNotification(Account account, ActionType action);
}
