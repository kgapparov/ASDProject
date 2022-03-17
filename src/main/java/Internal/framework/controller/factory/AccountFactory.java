package Internal.framework.controller.factory;

import Internal.framework.module.*;

public abstract class AccountFactory {
      public abstract Account createAccount(AccountType accountType, String accountNumber, Customer customer);
  }
