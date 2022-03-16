package Internal.framework.module;

import Internal.framework.controller.intereststate.LowInterestState;
import Internal.framework.controller.intereststate.MidInterestState;
import Internal.framework.controller.intereststate.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Account {
    private  AccountType accountType;
    private Customer customer;
    private String accountNumber;
    private List<NotificationStrategy> notificationStrategies;
    private List<AccountEntry> entryList = new ArrayList<>();
    private List<Observer> notificationObservers;

    public Account(Customer customer, String accountNumber, InterestCalculator interest, AccountType accountType) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.interest = interest;
        this.notificationStrategies = new ArrayList<>();
        this.notificationObservers = new ArrayList<>();
        this.accountType = accountType;
    }

    public InterestCalculator getInterest() {
        return interest;
    }

    private InterestCalculator interest;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(InterestCalculator interestCalculator) {
        this.interest = interestCalculator;
    }

    public Account(Customer customer, String accountNumber,InterestCalculator interest) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.interest = interest;
    }

    public void setInterest(InterestCalculator interest) {
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
        double interstAmt =0;
         if (interest != null) {
            interstAmt = interest.calculateInterest(this);
        }
        AccountEntry entry = new AccountEntry(interstAmt, "interest", "", "");
        entryList.add(entry);
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
    }

    public void addEntry(AccountEntry entry) {
        entryList.add(entry);
        this.notificationStrategies.forEach(notificationStrategy -> notificationStrategy.execute(this));
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

    public List<AccountEntry> getEntryList() {
        return entryList;
    }

    public abstract String getAccountType();

    public List<Observer> getNotificationObservers() {
        return notificationObservers;
    }

}
