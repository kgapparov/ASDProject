package Internal.creditcard.model;

import Internal.framework.model.*;

import java.time.LocalDate;

public class CreditCardAccount extends Account {
    private MinimumPaymentStrategy minimumPaymentStrategy;
    private String expireDate;

    public CreditCardAccount(Customer customer, String accountNumber, InterestCalculator interest,
                             MinimumPaymentStrategy minimumPaymentStrategy, AccountType type) {
        super(customer, accountNumber, interest, type);
        this.minimumPaymentStrategy = minimumPaymentStrategy;

    }

    public CreditCardAccount(Customer customer, String accountNumber, InterestCalculator interest) {
        super(customer, accountNumber, interest);
    }

    public String getExpireDate() {
        return expireDate;
    }

    public MinimumPaymentStrategy getMinimumPaymentStrategy() {
        return minimumPaymentStrategy;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }



    public double getPrevBalance() {
        LocalDate todaydate = LocalDate.now();
        return this.getEntryList().stream()
                .filter(accountEntry -> accountEntry.getDate().isBefore(todaydate.withDayOfMonth(1)))
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getTotalCredit() {
        LocalDate todaydate = LocalDate.now();
        return this.getEntryList().stream()
                .filter(accountEntry -> accountEntry.getDate().isAfter(todaydate.withDayOfMonth(1)))
                .filter(accountEntry -> accountEntry.getAmount() < 0)
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getTotalCharge() {
        LocalDate todaydate = LocalDate.now();
        return this.getEntryList().stream()
                .filter(accountEntry -> accountEntry.getDate().isAfter(todaydate.withDayOfMonth(1)))
                .filter(accountEntry -> accountEntry.getAmount() >= 0)
                .mapToDouble(AccountEntry::getAmount).sum();
    }

    public double getNewBalance() {
        return minimumPaymentStrategy.newBalanceCalculate(getPrevBalance(), getTotalCredit(), getTotalCharge(), minimumPaymentStrategy.MinimumPaymentRateValue());

    }

    public double getTotalDue() {
        //System.out.println("Interest value " + super.getInterest().interestRateValue());
        return super.getInterest().interestRateValue()* getNewBalance();
    }

}
