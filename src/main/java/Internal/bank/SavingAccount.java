package Internal.bank;


import Internal.framework.controller.interestCalculators.PersonalSavingInterestCalculator;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Customer;

;

public class SavingAccount extends Account {
    public SavingAccount(Customer customer, String accNum) {
        super(customer, accNum,new PersonalSavingInterestCalculator());

    }

    public String getAccountType() {
        return AccountType.SAVING.name();
    }
}
