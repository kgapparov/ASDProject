package Internal.framework.module;

public abstract class AccountFactory {
    MinimumPaymentStrategy minimumPaymentStrategy;
    InterestCalculator interestCalculator;
    //public abstract Account createAccount(String accountNumber, Customer customer);
    public abstract Account createAccount(AccountType accountType,String accountNumber, Customer customer);
  }
