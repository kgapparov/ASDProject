package Internal.framework.controller.interestCalculators;

import Internal.framework.module.Account;
import Internal.framework.module.InterestCalculator;

public class CompanyCheckingInterestCalculator extends InterestCalculator {
    @Override
    public double calculateInterest(Account account) {
        return  handleInterest(account) ;
    }
}