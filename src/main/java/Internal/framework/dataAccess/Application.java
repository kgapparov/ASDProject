package Internal.framework.dataAccess;

import Internal.bank.SavingAccount;
import Internal.framework.module.Account;
import Internal.framework.module.Customer;
import Internal.framework.module.Individual;

public class Application {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOMemoryImplementation();
        Customer customer = new Individual();
        customer.setClientName("Khassan");
        Account account = new SavingAccount(customer, "11235");
        account.deposit(2000);
        accountDAO.saveAccount(account);
        System.out.println(accountDAO.loadAccount("11235").getCustomer().getClientName()+"-" + accountDAO.loadAccount("11235").getAccountType());
        System.out.println(account.getBalance());
        account.addInterest();
        System.out.println(account.getBalance());
        account.addInterest();
        System.out.println(account.getBalance());
    }
}
