package Internal.framework.module;

import Internal.framework.controller.interest.interestCalculators.InterestCalculatorsRateEnum;

public class GoldInterest extends InterestCalculator {

    @Override
    public double calculateInterest(Account account) {
        return account.getBalance()* InterestCalculatorsRateEnum.MIGOLD.getValue();
    }

    @Override
    public double interestRateValue() {
        return InterestCalculatorsRateEnum.MIGOLD.getValue();
    }

}

