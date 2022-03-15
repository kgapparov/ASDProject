package Internal.framework.controller.interestCalculators;


import Internal.framework.module.Account;
import Internal.framework.module.InterestCalculator;

public class CompanySavingInterestCalculator extends InterestCalculator {
    @Override
    public double calculateInterest(Account account) {
        return handleInterest(account);
    }
}
