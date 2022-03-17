package Internal.framework.controller.interest.intereststate;

import Internal.framework.model.Account;

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
