package Internal.framework.module;

public class CreditCardEmailSender implements Observer{

    public CreditCardEmailSender() {}

    @Override
    public void update(Account account) {
        AccountEntry entry = account.getEntryList().get(account.getEntryList().size() - 1);
        System.out.println(entry.getAmount());
        if (account.getCustomer().getCustomerType() == CustomerType.COMPANY) {
            System.out.println("{Credit Card} Sending an email to COMPANY - " + account.getCustomer().getClientName());
        } else if (account.getCustomer().getCustomerType() == CustomerType.INDIVIDUAL && (
            entry.getAmount() >= 400 || account.getBalance() < 0)) {
            System.out.println("{Credit Card} Sending an email to INDIVIDUAL - " + account.getCustomer().getClientName() + " "
                    + account.getOperationName());
        }
    }
}
