package Internal.framework.controller;

import Internal.framework.module.Account;
import Internal.framework.module.AccountEntry;
import Internal.framework.module.ActionType;
import Internal.framework.module.NotificationStrategy;

public class AmountGreaterThan400 implements NotificationStrategy {
    @Override
    public void execute(Account account) {
        AccountEntry entry = account.getEntryList().get(account.getEntryList().size() - 1);
        if(entry.getAmount() >= 400){
            account.getNotificationObservers().forEach(observer -> observer.update(account, ActionType.WITHDRAW));
        }
    }
}
