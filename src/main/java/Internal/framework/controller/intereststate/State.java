package Internal.framework.controller.intereststate;

import Internal.framework.module.Account;
import Internal.framework.module.InterestCalculator;

public interface State {

   public abstract double handleInterest(Account account);
}
