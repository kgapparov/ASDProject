package Internal.creditcard;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.ui.ApplicationFrm;

public class CreditCardApplication extends AccountServiceApplicationFactory {
    @Override
    public void createCommands(ApplicationFrm form, AccountServiceApplicationFactory service) {

    }

    @Override
    public Account createAccount(AccountType type, String accountNumber, String customerName) {
        return null;
    }
}
