package Internal.framework.controller.intereststate;

import Internal.framework.module.Account;

public class LowInterestState extends State {

    @Override
    public double handleInterest(Account account) {
        if(account.getBalance() >= 1000){
            super.interestCalculator= account.getInterest();
            interestCalculator.setInterestState(new MidInterestState());
            return interestCalculator.handleInterest(account);
        }else{
        return account.getBalance()* 0.10;
        }
    }
}
