package Internal.framework.controller.interest.intereststate;

import Internal.framework.module.Account;

public class LowInterestState implements State {

    @Override
    public double handleInterest(Account account) {
        if(account.getBalance() > 1000){
            account.setInterestState(new MidInterestState());
            return account.getInterest().handleInterest(account);
        }else{
        return account.getBalance() * InterestRateEnum.LOWINTEREST.getValue();
        }
    }
}
