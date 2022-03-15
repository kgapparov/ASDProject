package Internal.framework.controller.intereststate;

import Internal.framework.module.Account;

public class MidInterestState extends State {
    @Override
    public double handleInterest(Account account){
      if(account.getBalance()>1000 && account.getBalance()<10000){
          return account.getBalance()* 0.25;
      }
        if(account.getBalance() < 1000){
            super.interestCalculator= account.getInterest();
            interestCalculator.setInterestState(new LowInterestState());

        }else if(account.getBalance()>10000){
            super.interestCalculator= account.getInterest();
            interestCalculator.setInterestState(new HighInterestState());
        }
            return interestCalculator.handleInterest(account);
    }
}
