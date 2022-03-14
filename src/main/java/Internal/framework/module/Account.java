package Internal.framework.module;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account {
    private Customer customer;

    private String accountNumber;

    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();


    private Interest interest;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(Customer customer,String accountNumber) {
        this.customer = customer;
        this.accountNumber = accountNumber;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void addInterest() {
        double balance = getBalance();
        double intRate = 0;
        if (interest != null) {
            intRate = interest.getInterest(balance);
        }
        balance *= (intRate/100);
        deposit(balance);
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getClientName());
        AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getClientName());

        entryList.add(fromEntry);

        toAccount.addEntry(toEntry);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }
}
