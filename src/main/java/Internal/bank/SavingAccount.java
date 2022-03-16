package Internal.bank;

import Internal.framework.controller.interestCalculators.PersonalSavingInterestCalculator;
import Internal.framework.module.*;

public class SavingAccount extends Account {

    public SavingAccount(Customer customer, String accNum, InterestCalculator interestCalculator) {
        super(customer, accNum,interestCalculator);
    }


    public String getAccountType() {
        return AccountType.SAVING.name();
    }
}
