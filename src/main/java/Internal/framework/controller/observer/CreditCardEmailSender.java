package Internal.framework.controller.observer;

import Internal.framework.model.Account;
import Internal.framework.model.AccountEntry;
import Internal.framework.model.CustomerType;

public class CreditCardEmailSender implements Observer{

    public CreditCardEmailSender() {}

    @Override
    public void update(Account account) {
        AccountEntry entry = account.getEntryList().get(account.getEntryList().size() - 1);
        if (account.getCustomer().getCustomerType() == CustomerType.COMPANY) {
            System.out.println("{Credit Card} Sending an email to COMPANY - " + account.getCustomer().getClientName()
                    + " " + entry.getDescription() + " " + entry.getAmount());
        } else if (account.getCustomer().getCustomerType() == CustomerType.INDIVIDUAL && (
            entry.getAmount() >= 400 || account.getBalance() < 0)) {
            System.out.println("{Credit Card} Sending an email to INDIVIDUAL - " + account.getCustomer().getClientName()
                    + " " + entry.getDescription() + " " + entry.getAmount());
        } else if (entry.getAmount() <= -400) {
            System.out.println("{Credit Card} Sending an email to INDIVIDUAL - " + account.getCustomer().getClientName()
                    + " " + entry.getDescription() + " " + entry.getAmount());
        }
    }
}
