package Internal.framework.controller;

import Internal.bank.CheckingAccount;
import Internal.bank.SavingAccount;
import Internal.framework.dataAccess.AccountDAO;
import Internal.framework.dataAccess.AccountDAOMemoryImplementation;
import Internal.framework.dataAccess.StorageFactory;
import Internal.framework.module.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Facade pattern for AccountService
// Observer pattern for notification service
// Strategy pattern for setting the reporting mechanism

public class AccountServiceImpl implements AccountService {
    private final List<Observer> observers = new ArrayList<>();

    private AccountDAO accountDao;

    private StorageFactory storage;

    public StorageFactory getStorage() {
        return storage;
    }

    public AccountServiceImpl() {
        accountDao = new AccountDAOMemoryImplementation();
    }

    @Override
    public Account createAccount(AccountType type, String accountNumber, String customerName) {
        Customer customer = new Individual();
        customer.setClientName(customerName);
        Account account = new SavingAccount(customer, accountNumber);

        account.setCustomer(customer);

        accountDao.saveAccount(account);
        return account;
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountDao.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountDao.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDao.loadAccount(accountNumber);
        if (account != null) {
            AccountEntry entry = new AccountEntry(amount, "interest", "", "");
            accountDao.addEntry(entry, accountNumber);
            sendNotification(account);
        }
    }

    public void addNotificationService(Observer observer, String accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.addNotificationService(observer);
        }
    }

    public List<AccountEntry> getTransactions() {
        return accountDao.getEntries();
    }

//    public double getBalance(String accountNumber) {
//        return accountDao.getBalance(accountNumber);
//    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDao.loadAccount(accountNumber);
        if (account != null) {
            AccountEntry entry = new AccountEntry(amount, "interest", "", "");
            account.addEntry(entry);
            sendNotification(account);
        }
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void addInterest() {
        for (Account account : accountDao.getAccounts()) {
            double interestAmount = account.getInterest().calculateInterest(account);
            AccountEntry entry = new AccountEntry(interestAmount, "interest", "", "");
            accountDao.addEntry(entry, account.getAccountNumber());
        }
    }

    @Override
    public void buildReport() {

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendNotification(Account account) {
        for (Observer observer : observers) {
            observer.update(account);
        }
    }

//    public Report generateReport(ReportFactory reportFactory) {
//        return reportFactory.createReport();
//    }
}
