package Internal.framework.controller.interest.intereststate;

import Internal.framework.model.Account;

public class StandardInterestState implements State{


        @Override
        public double handleInterest(Account account) {
            return account.getBalance();
        }

}
