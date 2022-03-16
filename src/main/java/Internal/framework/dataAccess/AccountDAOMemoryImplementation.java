package Internal.framework.dataAccess;

import Internal.framework.module.Account;
import Internal.framework.module.AccountEntry;
import Internal.framework.module.Transaction;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AccountDAOMemoryImplementation implements AccountDAO{
    private final CommonDAO<Account> memAccount= new CommonDAOMemoryImplement<>();

    @Override
    public void saveAccount(Account account) {
        memAccount.save(account.getAccountNumber(), account);
    }

    @Override
    public void updateAccount(Account account) {
        memAccount.update(account.getAccountNumber(), account);
    }

    @Override
    public Account loadAccount(String accountNumber) {
        return memAccount.loadData(accountNumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        return memAccount.getAll();
    }

    @Override
    public List<AccountEntry> getEntries() {
        return memAccount.getAll().stream()
                .map(Account::getEntryList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public void addEntry(AccountEntry entry, String accountNumber) {
        var account = loadAccount(accountNumber);
        account.addEntry(entry);
    }
}
