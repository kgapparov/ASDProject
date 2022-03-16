package Internal.framework.controller;

import Internal.framework.dataAccess.ReportFactory;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.ActionType;
import Internal.framework.module.Report;

import java.util.Collection;

public interface AccountService {
    Account createAccount(AccountType type, String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest();
    void buildReport();
     void sendNotification(Account account, ActionType action);
}
