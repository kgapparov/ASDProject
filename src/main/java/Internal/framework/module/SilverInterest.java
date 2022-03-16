package Internal.framework.module;

public class SilverInterest extends InterestCalculator {

    @Override
    public double calculateInterest(Account account) {
        return account.getBalance()* 0.08;
    }

}
