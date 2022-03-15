package Internal.framework.module;

public class SilverInterest extends InterestCalculator {
   /* @Override
    public double getInterest(double balance) {
        return balance * 0.08;
    }
*/
    @Override
    public double calculateInterest(Account account) {
        return 0;
    }
}
