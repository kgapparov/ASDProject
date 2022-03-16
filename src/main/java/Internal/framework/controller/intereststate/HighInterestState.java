package Internal.framework.controller.intereststate;

import Internal.framework.module.Account;

public class HighInterestState implements   State  {



    @Override
    public double handleInterest(Account account) {
        if(account.getBalance() < 10000){
            account.setInterestState(new MidInterestState());
            return account.getInterest().handleInterest(account);
        }
        return account.getBalance()* 0.5;
    }
}
