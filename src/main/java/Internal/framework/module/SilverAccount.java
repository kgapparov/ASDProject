package Internal.framework.module;

public class SilverAccount extends CreditCardAccount {
    public SilverAccount(Customer customer, String accountNumber, Interest interest,
                         MinimumPaymentStrategy paymentStrategy) {
        super(customer, accountNumber, interest, paymentStrategy,"SILVER");
    }
}
