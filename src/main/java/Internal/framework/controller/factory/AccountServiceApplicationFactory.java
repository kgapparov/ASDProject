package Internal.framework.controller.factory;

import Internal.creditcard.ui.CardFrm;
import Internal.framework.model.EnvironmentType;
import Internal.framework.dataAccess.AccountDAO;
import Internal.framework.dataAccess.MemoryStorageFactory;
import Internal.framework.dataAccess.StorageFactory;
import Internal.framework.model.*;
import Internal.framework.controller.observer.Observer;
import Internal.bank.ui.ApplicationFrm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AccountServiceApplicationFactory implements AccountService {
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

    private final List<Observer> observers = new ArrayList<>();

    public void setEnvType(EnvironmentType envType) {
        if (envType == EnvironmentType.MEMORY) {
            storage = new MemoryStorageFactory();
            accountDAO = storage.getAccountDAO();
        } else {
            storage = null;
        }
    }
    public abstract void createCommands(ApplicationFrm form, AccountServiceApplicationFactory service);

    public abstract void createCommands(CardFrm form, AccountServiceApplicationFactory service);

    public abstract void init(EnvironmentType envType);

  /*  public Account createAccount(AccountType type, String accountNumber, String customerName)
    {
        Optional<Customer> customer = Optional.ofNullable(getStorage().getCustomerDAO().loadCustomer(customerName));
        Account acc = customer.map(x -> createConcreteAccount(type, x, accountNumber)).get();
        accountDAO.saveAccount(acc);
        return acc;
    }*/

    public abstract Account createConcreteAccount(AccountType accountType, Customer customer, String accountNumber);

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
            sendNotification(account);
        } else {
            System.out.println("Account is null");
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount){
        Account account = accountDAO.loadAccount(accountNumber);
        if (account != null ) {
            account.deposit(-amount);
            accountDAO.updateAccount(account);
            sendNotification(account);
        } else {
            System.out.println("Account is null");
        }
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
    public void sendNotification(Account account) {
        for (Observer observer : observers) {
            observer.update(account);
        }
    }

    public void run (AccountServiceApplicationFactory service, ApplicationFrm form) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Create a new instance of our application's frame, and make it visible.
            service.createCommands(form, service);
            service.init(EnvironmentType.MEMORY);
            form.setAccountService(service);
            form.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
    public void run (AccountServiceApplicationFactory service, CardFrm form) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Create a new instance of our application's frame, and make it visible.
            service.createCommands(form, service);
            service.init(EnvironmentType.MEMORY);
            form.setAccountService(service);
            form.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

}
