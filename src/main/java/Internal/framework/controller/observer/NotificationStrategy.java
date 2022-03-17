package Internal.framework.controller.observer;

import Internal.framework.model.Account;

public interface NotificationStrategy {
    void execute(Account account);
}
