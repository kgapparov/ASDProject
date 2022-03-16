package Internal.framework.module;

public class BronzeInterest extends InterestCalculator {
   /* @Override
    public double getInterest(double balance) {
        return balance * 0.1;
    }*/

    @Override
    public double calculateInterest(Account account) {
        return 0;
    }
}
