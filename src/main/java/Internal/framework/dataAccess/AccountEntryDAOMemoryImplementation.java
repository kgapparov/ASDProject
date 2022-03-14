package Internal.framework.dataAccess;

import Internal.framework.module.AccountEntry;

import java.util.Collection;

public class AccountEntryDAOMemoryImplementation implements AccountEntryDAO{
    private final CommonDAO<AccountEntry> accountEntries;

    public AccountEntryDAOMemoryImplementation() {
        this.accountEntries = new CommonDAOMemoryImplement<>();
    }

    @Override
    public void saveAccountEntry(AccountEntry accountEntry) {
        this.accountEntries.save(accountEntry.getDate().toString(), accountEntry);
    }

    @Override
    public void updateAccountEntry(AccountEntry accountEntry) {
        this.accountEntries.update(accountEntry.getDate().toString(), accountEntry);
    }

    @Override
    public AccountEntry loadAccountEntry(String accountEntryNumber) {
        return accountEntries.loadData(accountEntryNumber);
    }

    @Override
    public Collection<AccountEntry> getAccountEntrys() {
        return accountEntries.getAll();
    }
}
