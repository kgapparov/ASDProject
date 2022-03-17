package Internal.creditcard.model;

import Internal.framework.model.*;

public class GoldAccount extends CreditCardAccount {
    public GoldAccount(Customer customer, String accountNumber, InterestCalculator interest,
                       MinimumPaymentStrategy paymentStrategy) {
        super(customer, accountNumber, interest, paymentStrategy, AccountType.GOLDEN);
    }
}

