package Internal.framework.dataAccess;

import Internal.bank.SavingAccount;
import Internal.creditcard.CreditCardApplication;
import Internal.framework.controller.AccountService;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.AccountServiceImpl;
import Internal.framework.controller.AmountGreaterThan400;
import Internal.framework.module.*;

public class Application {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOMemoryImplementation();
        Customer customer = new Individual();
        customer.setClientName("Khassan");
        Account account = new SavingAccount(customer, "11235");
        account.deposit(2000);
        accountDAO.saveAccount(account);
        System.out.println(accountDAO.loadAccount("11235").getCustomer().getClientName()+"-"
                + accountDAO.loadAccount("11235").getAccountType());
        System.out.println(account.getBalance());
        account.addInterest();
        System.out.println(account.getBalance());
        account.addInterest();
        System.out.println(account.getBalance());

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
