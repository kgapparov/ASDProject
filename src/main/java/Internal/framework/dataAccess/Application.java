package Internal.framework.dataAccess;

import Internal.bank.CheckingAccount;
import Internal.bank.SavingAccount;
import Internal.framework.module.*;

public class Application {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOMemoryImplementation();
        Customer customer = new Individual();
        customer.setClientName("Khassan");
        Account savingAccount = new SavingAccount(customer, "11235");
        Account checkingAccount = new CheckingAccount(customer, "11236");
        GoldCreditCardFactory a = new GoldCreditCardFactory();

        Account goldenCreditCard= a.createAccount("123", customer);
        //deposit
        savingAccount.deposit(100);
        checkingAccount.deposit(100);
        goldenCreditCard.deposit(100);

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


    }
}
