package Internal.framework.controller.interest.interestCalculators;


import Internal.framework.model.Account;
import Internal.framework.model.InterestCalculator;

public  class PersonalCheckingInterestCalculator extends InterestCalculator {
    @Override
    public double calculateInterest(Account account) {
        return handleInterest(account) ;
    }

}
