package Internal.framework.controller.interest.interestCalculators;

import Internal.framework.module.Account;
import Internal.framework.module.InterestCalculator;

public class PersonalSavingInterestCalculator extends InterestCalculator {
    @Override
    public double calculateInterest(Account account) {
        return handleInterest(account);
    }
}
