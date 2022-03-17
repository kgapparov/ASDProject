package Internal.framework.module;

public class SilverInterest extends InterestCalculator {

    @Override
    public double calculateInterest(Account account) {
        return account.getBalance()* 0.08;
    }

    @Override
    public double interestRateValue() {
        return 0.08;
    }

}
