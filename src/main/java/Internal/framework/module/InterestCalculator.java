package Internal.framework.module;

public abstract class InterestCalculator {


   public abstract double calculateInterest(Account account);

    public double handleInterest(Account account){
        return account.getInterestState().handleInterest(account);
    }

    public  double calculateBalance(double prevBalance, double totalCredit, double totalCharge){
        return 0;
    }


}
