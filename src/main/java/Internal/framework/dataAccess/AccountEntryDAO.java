package Internal.framework.dataAccess;

import Internal.framework.module.AccountEntry;

import java.util.Collection;

public interface AccountEntryDAO{
    void saveAccountEntry(AccountEntry accountEntry);
    void updateAccountEntry(AccountEntry accountEntry);
    AccountEntry loadAccountEntry(String accountEntryNumber);
    Collection<AccountEntry> getAccountEntrys();
}
