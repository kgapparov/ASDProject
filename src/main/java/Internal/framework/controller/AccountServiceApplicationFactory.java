package Internal.framework.controller;

import Internal.bank.CheckingAccount;
import Internal.bank.SavingAccount;
import Internal.framework.dataAccess.AccountDAO;
import Internal.framework.dataAccess.MemoryStorageFactory;
import Internal.framework.dataAccess.StorageFactory;
import Internal.framework.module.*;
import Internal.framework.ui.ApplicationFrm;

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

    public abstract void init(EnvironmentType envType);

    public Account createAccount(AccountType type, String accountNumber, String customerName) {
        Customer customer = getStorage().getCustomerDAO().loadCustomer(customerName);
        Account acc;
        if (customer != null) {
            Account account;
            if (customer instanceof Individual) {
                if (type == AccountType.CHECKING) {
                    acc = new CheckingAccount(customer, accountNumber);
                    accountDAO.saveAccount(acc);
                    return acc;
                }
                acc = new SavingAccount(customer, accountNumber);
                accountDAO.saveAccount(acc);
                return acc;
            }
            if (type == AccountType.CHECKING) {
                acc = new CheckingAccount(customer, accountNumber);
                accountDAO.saveAccount(acc);
                return acc;
            }
            acc = new SavingAccount(customer, accountNumber);
            accountDAO.saveAccount(acc);
            return acc;
        }
        return null;
    }


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
        if (account != null ) {
            account.deposit(amount);
            accountDAO.updateAccount(account);
            sendNotification(account, ActionType.DEPOSIT);
        } else {
            System.out.println("Account is null");
        }
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
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<Observer> getNotificationObservers() {
        return observers;
    }

    @Override
    public void sendNotification(Account account, ActionType action) {
        for (Observer observer : observers) {
            observer.update(account, action);
        }
    }

}
