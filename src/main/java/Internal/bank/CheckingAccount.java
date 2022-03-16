package Internal.bank;


import Internal.framework.controller.interestCalculators.PersonalCheckingInterestCalculator;
import Internal.framework.controller.interestCalculators.PersonalSavingInterestCalculator;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Customer;


public class CheckingAccount extends Account {
    public CheckingAccount(Customer customer, String accNum) {
        super(customer, accNum,new PersonalCheckingInterestCalculator());

    }

    public String getAccountType() {
        return AccountType.CHECKING.name();
    }


}
