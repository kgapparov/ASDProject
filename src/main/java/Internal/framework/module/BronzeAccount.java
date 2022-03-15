package Internal.framework.module;

public class BronzeAccount extends CreditCardAccount {
    public BronzeAccount(Customer customer, String accountNumber, Interest interest,
                         MinimumPaymentStrategy paymentStrategy) {
        super(customer, accountNumber, interest, paymentStrategy, "BRONZE");
    }
}
