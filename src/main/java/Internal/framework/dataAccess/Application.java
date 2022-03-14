package Internal.framework.dataAccess;

import Internal.framework.module.Account;
import Internal.framework.module.Customer;
import Internal.framework.module.Individual;

public class Application {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOMemoryImplementation();
        Customer customer = new Individual();
        customer.setClientName("Khassan");
        Account account = new Account(customer, "11235");
        accountDAO.saveAccount(account);
       System.out.println(accountDAO.loadAccount("11235").getCustomer().getClientName());
    }
}
