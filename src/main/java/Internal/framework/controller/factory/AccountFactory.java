package Internal.framework.controller.factory;

import Internal.framework.model.*;

public abstract class AccountFactory {
      public abstract Account createAccount(AccountType accountType, String accountNumber, Customer customer);
  }
