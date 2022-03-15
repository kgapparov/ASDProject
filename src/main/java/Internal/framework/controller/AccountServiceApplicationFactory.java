package Internal.framework.controller;

import Internal.framework.dataAccess.AccountDAO;
import Internal.framework.dataAccess.MemoryStorageFactory;
import Internal.framework.dataAccess.StorageFactory;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.ui.ApplicationFrm;
import Internal.framework.module.ActionType;
import Internal.framework.module.Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AccountServiceApplicationFactory implements AccountService{
    private AccountDAO accountDAO;

    private EnvironmentType envType;

    private StorageFactory storage;

    public StorageFactory getStorage() {
        return storage;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public EnvironmentType getEnvType() {
        return envType;
    }

    private List<Observer> observers = new ArrayList<>();

    public void setEnvType(EnvironmentType envType) {
        if (envType == EnvironmentType.MEMORY) {
            storage = new MemoryStorageFactory();
            accountDAO = storage.getAccountDAO();
        } else {
            storage = null;
        }
    }
    public abstract void createCommands(ApplicationFrm form, AccountServiceApplicationFactory service);

    public abstract Account createAccount(AccountType type, String accountNumber, String customerName);

    @Override
    public Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        sendNotification(account, ActionType.DEPOSIT);
    }

    @Override
    public void withdraw(String accountNumber, double amount){
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(-amount);
        accountDAO.updateAccount(account);
        sendNotification(account, ActionType.WITHDRAW);
    }


    @Override
    public void addInterest() {
        Collection<Account> accounts = getAllAccounts();
        for (Account account: accounts) {
            account.addInterest();
        }
    }

    @Override
    public void sendNotification(Account account, ActionType action) {
        for (Observer o : observers) {
            o.update(account, action);
        }
    }

}
