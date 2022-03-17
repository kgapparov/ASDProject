package Internal.framework.module;

public class BronzeInterest extends InterestCalculator {


    @Override
    public double calculateInterest(Account account) {

        return account.getBalance()* 0.10;
    }

    @Override
    public double interestRateValue() {
        return 0.10;
    }


}
