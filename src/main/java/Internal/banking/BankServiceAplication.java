package Internal.banking;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.dataAccess.ReportFactory;
import Internal.framework.module.*;

public class BankServiceAplication extends AccountServiceApplicationFactory {
    @Override
    public Account createAccount(AccountType type, String accountNumber, String customerName) {
        //setup environment
        super.setEnvType(EnvironmentType.MEMORY);

        //setInterest type
        Customer customer = super.getStorage().getCustomer().loadCustomer(customerName);
        if (customer != null) {
            Account account = new Account(customer, accountNumber, new Interest() {
                @Override
                public double getInterest(double balance) {
                    return 1.2;
                }
            }, "GOLD");
            //TODO set interest value depending on type of account
            return account;
        }
        return null;
    }
}
