package Internal.framework.dataAccess;

import Internal.framework.module.Account;
import Internal.framework.module.AccountEntry;
import Internal.framework.module.Transaction;

import java.util.Collection;

public interface AccountDAO {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountNumber);
    Collection<Account> getAccounts();
    void addEntry(AccountEntry entry, String accountNumber);
}
