package Internal.ccard;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;

public class CreditCardApplication extends AccountServiceApplicationFactory {
    @Override
    public Account createAccount(AccountType type, String accountNumber, String customerName) {
        return null;
    }
}
