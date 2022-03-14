package Internal.framework.dataAccess;

public abstract class StorageFactory {
    private AccountDAO account;
    private AccountEntryDAO cccountEntry;
    private CustomerDAO customer;

    public AccountDAO getAccount() {
        return account;
    }

    public AccountEntryDAO getCccountEntry() {
        return cccountEntry;
    }

    public CustomerDAO getCustomer() {
        return customer;
    }

    public void setAccount(AccountDAO account) {
        this.account = account;
    }

    public void setCccountEntry(AccountEntryDAO cccountEntry) {
        this.cccountEntry = cccountEntry;
    }

    public void setCustomer(CustomerDAO customer) {
        this.customer = customer;
    }
}
