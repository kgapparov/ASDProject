package Internal.framework.module;

import java.time.LocalDate;

public class Transaction {
    private Account account;
    private double amount;
    private String description;
    private LocalDate date;

    public Transaction(Account account, double amount, String description, LocalDate date) {
        this.account = account;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "account=" + account.getAccountNumber() +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}'+"\n";
    }
}