package Internal.bank;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Customer;

public class BankServiceAplication extends AccountServiceApplicationFactory {
    @Override
    public Account createAccount(AccountType type, String accountNumber, String customerName) {
        //setup environment
        super.setEnvType(EnvironmentType.MEMORY);

        //setInterest type
        Customer customer = super.getStorage().getCustomer().loadCustomer(customerName);
        if (customer != null) {
            Account account = new Account(customer, accountNumber);
            //TODO set interest value depending on type of account
            return account;
        }
        return null;
    }
}
