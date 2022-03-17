package Internal.framework.controller.observer;

import Internal.framework.model.Account;
import Internal.framework.model.AccountEntry;
import Internal.framework.model.CustomerType;

public class BankEmailSender implements Observer{

    public BankEmailSender() {}

    @Override
    public void update(Account account) {
        AccountEntry entry = account.getEntryList().get(account.getEntryList().size() - 1);
        if (account.getCustomer().getCustomerType() == CustomerType.COMPANY) {
            System.out.println("{Banking} Sending an email to COMPANY - " + account.getCustomer().getClientName() + " "
                    + entry.getDescription() + " " + entry.getAmount());
        } else if (account.getCustomer().getCustomerType() == CustomerType.INDIVIDUAL && (
            entry.getAmount() >= 500 || account.getBalance() < 0)) {
            System.out.println("{Banking} Sending an email to INDIVIDUAL - " + account.getCustomer().getClientName()
                    + " " + entry.getDescription() + " " + entry.getAmount());
        } else if (entry.getAmount() <= -500) {
            System.out.println("{Banking} Sending an email to INDIVIDUAL - " + account.getCustomer().getClientName()
                    + " " + entry.getDescription() + " " + entry.getAmount());
        }
    }
}
