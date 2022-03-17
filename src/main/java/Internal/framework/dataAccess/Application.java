package Internal.framework.dataAccess;

import Internal.bank.CheckingAccount;
import Internal.bank.BankServiceAplication;
import Internal.bank.SavingAccount;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.controller.interest.interestCalculators.CompanySavingInterestCalculator;
import Internal.framework.controller.interest.interestCalculators.PersonalCheckingInterestCalculator;
import Internal.framework.controller.interest.interestCalculators.PersonalSavingInterestCalculator;
import Internal.framework.module.*;
import Internal.creditcard.controller.CreditCardApplication;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.command.Invoker;
import Internal.framework.controller.command.ReportCommand;
import Internal.framework.module.Account;
import Internal.framework.module.Customer;
import Internal.framework.module.Individual;

public class Application {
    public static void main(String[] args) {
      /*  AccountServiceApplicationFactory accountServiceApplicationFactory = new BankServiceAplication();
        AccountDAO accountDAO = new AccountDAOMemoryImplementation();
        accountServiceApplicationFactory.setAccountDAO(accountDAO);

        Customer customer = new Individual();
        customer.setClientName("Khassan");
        Account savingAccount = new SavingAccount(customer, "11235", new PersonalSavingInterestCalculator());
        Account checkingAccount = new CheckingAccount(customer, "11236", new PersonalCheckingInterestCalculator());


        GoldCreditCardFactory a = new GoldCreditCardFactory();
        Customer customerCompany = new Company();
        Account companyAccount = new SavingAccount(customerCompany, "111", new PersonalCheckingInterestCalculator());
        System.out.println(companyAccount);
        companyAccount.deposit(100);
        companyAccount.addInterest();
        System.out.println(companyAccount.getBalance());

        Account goldenCreditCard = a.createAccount("123", customer);
        //deposit
        savingAccount.deposit(44444);
        checkingAccount.deposit(44444);
        goldenCreditCard.deposit(44444);

        //save
        accountDAO.saveAccount(savingAccount);
        accountDAO.saveAccount(checkingAccount);
        accountDAO.saveAccount(goldenCreditCard);

        AccountServiceApplicationFactory accountServiceApplicationFactory1 = new BankServiceAplication();
        accountServiceApplicationFactory1.createConcreteAccount(AccountType.CHECKING, customer, "123");

        System.out.println(accountDAO.loadAccount("11235").getCustomer().getClientName() + "-" + accountDAO.loadAccount("11235").getAccountType());

        //print balance
        System.out.println("Saving Account: " + savingAccount.getBalance());
        System.out.println("Checking Account: " + checkingAccount.getBalance());
        System.out.println("CreditCard Account: " + goldenCreditCard.getBalance());
        //System.out.println("CreditCard Account new Balance: " +goldenCreditCar);

        //add interest
        savingAccount.addInterest();
        checkingAccount.addInterest();
        goldenCreditCard.addInterest();

        //print balance after Interest
        System.out.println("Saving Account: " + savingAccount.getBalance());
        System.out.println("Checking Account: " + checkingAccount.getBalance());
        System.out.println("CreditCard Account: " + goldenCreditCard.getBalance());


        Account account = accountServiceApplicationFactory1.createConcreteAccount(AccountType.CHECKING, customer, "11235");
        account.deposit(2000);
        accountDAO.saveAccount(account);
        account.addInterest();
        account.addInterest();


        Customer customer2 = new Individual();
        customer2.setClientName("Mahmoud Anwar");
        Account account2 = new CheckingAccount(customer2, "55678", new CompanySavingInterestCalculator());
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

        AccountServiceApplicationFactory creditCardApplication = new CreditCardApplication();
        AccountDAO accountDAO1 = new AccountDAOMemoryImplementation();
        creditCardApplication.setAccountDAO(accountDAO1);

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

        System.out.println(accountService.getAccount("12345").getBalance()); */

        AccountServiceApplicationFactory creditCardApplication1 = new CreditCardApplication();
        AccountDAO accountDAO2 = new AccountDAOMemoryImplementation();
        creditCardApplication1.setAccountDAO(accountDAO2);
        creditCardApplication1.init(EnvironmentType.MEMORY);

        Customer custome2r2 = new Individual();
        custome2r2.setClientName("test credit");

        Account creditCardPronz =  creditCardApplication1.createConcreteAccount(AccountType.BRONZE,custome2r2,"test credit");
        accountDAO2.saveAccount(creditCardPronz);

        creditCardApplication1.deposit("test credit",5000);
        creditCardApplication1.buildReport();

     }
}
