package Internal.framework.dataAccess;

import Internal.framework.model.Account;
import Internal.framework.model.AccountEntry;

import java.util.Collection;
import java.util.List;

public interface AccountDAO {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountNumber);
    Collection<Account> getAccounts();
    List<AccountEntry> getEntries();
    void addEntry(AccountEntry entry, String accountNumber);
}
