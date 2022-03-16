package Internal.bank;



import Internal.framework.module.*;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Customer;


public class SavingAccount extends Account {

    public SavingAccount(Customer customer, String accNum, InterestCalculator interestCalculator) {
        super(customer, accNum,interestCalculator);
    }


    public String getAccountType() {
        return AccountType.SAVING.name();
    }
}
