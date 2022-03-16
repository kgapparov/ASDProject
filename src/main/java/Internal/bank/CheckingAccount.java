package Internal.bank;


import Internal.framework.module.*;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Customer;



public class CheckingAccount extends Account {
    public CheckingAccount(Customer customer, String accNum,InterestCalculator interestCalculator) {
        super(customer, accNum,interestCalculator);
    }

    public String getAccountType() {
        return AccountType.CHECKING.name();
    }


}
