package Internal.framework.module;

public class GoldAccount extends CreditCardAccount{
    public GoldAccount(Customer customer, String accountNumber, Interest interest,
                       MinimumPaymentStrategy paymentStrategy) {
        super(customer, accountNumber, interest, paymentStrategy,"GOLD");
    }
}

