package Internal.creditcard;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.dataAccess.ReportFactory;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Report;

public class CreditCardApplication extends AccountServiceApplicationFactory {
    @Override
    public Account createAccount(AccountType type, String accountNumber, String customerName) {
        return null;
    }
}
