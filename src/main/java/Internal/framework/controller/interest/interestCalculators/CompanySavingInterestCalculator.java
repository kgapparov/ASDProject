package Internal.framework.controller.interest.interestCalculators;


import Internal.framework.model.Account;
import Internal.framework.model.InterestCalculator;

public class CompanySavingInterestCalculator extends InterestCalculator {

    @Override
    public double calculateInterest(Account account) {

        System.out.println("xxx");
        return handleInterest(account)*50;
    }

}
