package Internal.framework.module;

import Internal.framework.controller.intereststate.LowInterestState;
import Internal.framework.controller.intereststate.State;

public abstract class InterestCalculator {


   public abstract double calculateInterest(Account account);

    public double handleInterest(Account account){
        return account.getInterestState().handleInterest(account);
    }


}
