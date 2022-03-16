package Internal.framework.controller;

import Internal.framework.dataAccess.ReportFactory;
import Internal.framework.module.*;

import java.util.Collection;

public interface AccountService extends StateNotifyer {
    Account createAccount(AccountType type, String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest();
    void buildReport();
    void sendNotification(Account account);
}
