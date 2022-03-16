package Internal.framework.controller.intereststate;

import Internal.framework.module.Account;

public class HighInterestState extends  State  {



    @Override
    public double handleInterest(Account account) {
        if(account.getBalance() < 10000){
            super.interestCalculator= account.getInterest();
            interestCalculator.setInterestState(new MidInterestState());
            return interestCalculator.handleInterest(account);
        }
        return account.getBalance()* 0.5;
    }
}
