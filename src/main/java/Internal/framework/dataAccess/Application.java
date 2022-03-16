package Internal.framework.dataAccess;

import Internal.bank.BankServiceAplication;
import Internal.bank.CheckingAccount;
import Internal.bank.SavingAccount;
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

         ReportCommand reportCommand = new ReportCommand(accountServiceApplicationFactory);
        Invoker invoker = new Invoker();
        invoker.setCommand(0,reportCommand);


         reportCommand.execute();

        AccountServiceApplicationFactory accountServiceApplicationFactory1 = new CreditCardApplication();
        AccountDAO accountDAO1 = new AccountDAOMemoryImplementation();
        accountServiceApplicationFactory1.setAccountDAO(accountDAO1);

        ReportCommand reportCommand1 = new ReportCommand(accountServiceApplicationFactory1);
        reportCommand1.execute();
    }
}
