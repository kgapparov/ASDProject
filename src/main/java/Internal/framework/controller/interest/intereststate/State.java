package Internal.framework.controller.interest.intereststate;

import Internal.framework.model.Account;

public interface State {

   public abstract double handleInterest(Account account);
}
