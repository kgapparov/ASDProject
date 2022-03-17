package Internal.framework.model;

public abstract class InterestCalculator {


   public abstract double calculateInterest(Account account);
    public double interestRateValue(){
        return 0;
    }

    public double handleInterest(Account account){
        return account.getInterestState().handleInterest(account);
    }




}
