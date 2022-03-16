package Internal.framework.dataAccess;

import Internal.bank.CheckingAccount;
import Internal.bank.BankServiceAplication;
import Internal.bank.CheckingAccount;
import Internal.bank.SavingAccount;
import Internal.framework.controller.AccountServiceImpl;
import Internal.framework.controller.AmountGreaterThan400;
import Internal.framework.module.*;
import Internal.creditcard.CreditCardApplication;
import Internal.framework.controller.AccountService;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.command.Invoker;
import Internal.framework.controller.command.ReportCommand;
import Internal.framework.module.Account;
import Internal.framework.module.Customer;
import Internal.framework.module.Individual;
import Internal.framework.ui.ApplicationFrm;

public class Application {
    public static void main(String[] args) {
        AccountServiceApplicationFactory accountServiceApplicationFactory = new BankServiceAplication();
        AccountDAO accountDAO = new AccountDAOMemoryImplementation();
        accountServiceApplicationFactory.setAccountDAO(accountDAO);

        Customer customer = new Individual();
        customer.setClientName("Khassan");
        Account savingAccount = new SavingAccount(customer, "11235");
        Account checkingAccount = new CheckingAccount(customer, "11236");
        GoldCreditCardFactory a = new GoldCreditCardFactory();

        Account goldenCreditCard= a.createAccount("123", customer);
        //deposit
        savingAccount.deposit(44444);
        checkingAccount.deposit(44444);
        goldenCreditCard.deposit(44444);

        //save
        accountDAO.saveAccount(savingAccount);
        accountDAO.saveAccount(checkingAccount);
        accountDAO.saveAccount(goldenCreditCard);

        System.out.println(accountDAO.loadAccount("11235").getCustomer().getClientName()+"-" + accountDAO.loadAccount("11235").getAccountType());

        //print balance
        System.out.println("Saving Account: " +savingAccount.getBalance());
        System.out.println("Checking Account: " +checkingAccount.getBalance());
        System.out.println("CreditCard Account: " +goldenCreditCard.getBalance());

        //add interest
        savingAccount.addInterest();
        checkingAccount.addInterest();
        goldenCreditCard.addInterest();

        //print balance after Interest
        System.out.println("Saving Account: " +savingAccount.getBalance());
        System.out.println("Checking Account: " +checkingAccount.getBalance());
        System.out.println("CreditCard Account: " +goldenCreditCard.getBalance());


        Account account = new SavingAccount(customer, "11235");
        account.deposit(2000);
        accountDAO.saveAccount(account);
        account.addInterest();
         account.addInterest();


        Customer customer2= new Individual();
        customer2.setClientName("Mahmoud Anwar");
        Account account2 = new CheckingAccount(customer2, "55678");
        account2.deposit(6000);
        account2.deposit(1000);
        accountDAO.saveAccount(account2);
        account2.addInterest();
        account2.addInterest();
        account2.addInterest();

         ReportCommand reportCommand = new ReportCommand(accountServiceApplicationFactory);
        Invoker invoker = new Invoker();
       // invoker.setCommand(0,reportCommand);


         reportCommand.execute();

        AccountServiceApplicationFactory accountServiceApplicationFactory1 = new CreditCardApplication();
        AccountDAO accountDAO1 = new AccountDAOMemoryImplementation();
        accountServiceApplicationFactory1.setAccountDAO(accountDAO1);

        ReportCommand reportCommand1 = new ReportCommand(accountServiceApplicationFactory1);
        reportCommand1.execute();

        //Observer
        System.out.println("---------------------------");
        AccountServiceImpl accountService = new AccountServiceImpl();
        EmailSender emailSender = new EmailSender(accountService);
//        EmailSender.getInstance(account);
//        account.addNotificationStrategy(new AmountGreaterThan400());
        accountService.createAccount(AccountType.CHECKING, "12345", "Altangerel");
        accountService.deposit("12345", 100000);
        accountService.getAccount("12345").addNotificationStrategy(new AmountGreaterThan400());
        accountService.deposit("12345", 100000);
        accountService.updateAccount(accountService.getAccount("12345"));
        accountService.deposit("12345", 100000);

        System.out.println(accountService.getAccount("12345").getBalance());
    }
}
