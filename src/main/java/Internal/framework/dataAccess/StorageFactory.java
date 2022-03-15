package Internal.framework.dataAccess;

public abstract class StorageFactory {
    private AccountDAO accountDAO;
    private AccountEntryDAO accountEntryDAO;
    private CustomerDAO customerDAO;

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public AccountEntryDAO getAccountEntryDAO() {
        return accountEntryDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setAccountEntryDAO(AccountEntryDAO accountEntryDAO) {
        this.accountEntryDAO = accountEntryDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
