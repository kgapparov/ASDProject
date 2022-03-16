package Internal.framework.dataAccess;

import Internal.framework.module.*;

public class GoldCreditCardFactory extends AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer) {

        return new GoldAccount(customer, accountNumber, new GoldInterest(), new GoldMinimumPaymentStrategy());
    }


}
