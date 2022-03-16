package Internal.framework.module;

import Internal.framework.controller.intereststate.LowInterestState;
import Internal.framework.controller.intereststate.State;

public abstract class InterestCalculator {


   public abstract double calculateInterest(Account account);

    private State interestState = new LowInterestState();

    public void setInterestState(State state) {
        this.interestState = state;
    }

    public double handleInterest(Account account){
        return interestState.handleInterest(account);
    }


}
