package Internal.framework.module;

public class CreditCardAccount extends Account {
    private MinimumPaymentStrategy minimumPaymentStrategy;
    private String expireDate;

    public CreditCardAccount(Customer customer, String accountNumber, InterestCalculator interest,
                             MinimumPaymentStrategy minimumPaymentStrategy, AccountType type) {
        super(customer, accountNumber, interest, type);
        this.minimumPaymentStrategy = minimumPaymentStrategy;
    }

    public String getExpireDate() { return expireDate;}

    public MinimumPaymentStrategy getMinimumPaymentStrategy() { return minimumPaymentStrategy; }

    public void setExpireDate(String expireDate) { this.expireDate = expireDate; }

    @Override
    public String getAccountType() {
        return null;
    }
}
