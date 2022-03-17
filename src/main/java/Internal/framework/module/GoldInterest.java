package Internal.framework.module;

public class GoldInterest extends InterestCalculator {

    @Override
    public double calculateInterest(Account account) {
        return account.getBalance()* 0.06;
    }

    @Override
    public double interestRateValue() {
        return 0.06;
    }

}

