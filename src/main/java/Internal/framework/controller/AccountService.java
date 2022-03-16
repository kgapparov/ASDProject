package Internal.framework.controller;

import Internal.framework.dataAccess.ReportFactory;
import Internal.framework.module.*;

import java.util.Collection;


public interface AccountService extends StateNotifyer {
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest();
    String buildReport();
    void sendNotification(Account account);
}
