package Internal.framework.controller;

import Internal.framework.module.Account;
import Internal.framework.module.AccountType;

import java.util.Collection;

public interface AccountService {
    Account createAccount(AccountType type, String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest();
}
