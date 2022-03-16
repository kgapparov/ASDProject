package Internal.framework.controller.interest.intereststate;

import Internal.framework.controller.interest.intereststate.HighInterestState;
import Internal.framework.controller.interest.intereststate.InterestRateEnum;
import Internal.framework.controller.interest.intereststate.LowInterestState;
import Internal.framework.controller.interest.intereststate.State;
import Internal.framework.module.Account;

public class MidInterestState implements State {
    @Override
    public double handleInterest(Account account){
      if(account.getBalance()>1000 && account.getBalance()<=10000) {
          return account.getBalance() * InterestRateEnum.MIDINTEREST.getValue();
      }
        if(account.getBalance() < 1000){
            account.setInterestState(new LowInterestState());

        }else if(account.getBalance()>10000){
            account.setInterestState(new HighInterestState());
        }
            return account.getInterest().handleInterest(account);
    }
}
