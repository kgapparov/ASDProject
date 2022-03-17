package Internal.framework.controller.observer;

import Internal.framework.model.Account;

public interface StateNotifyer {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void sendNotification(Account account);
}
