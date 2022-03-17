package Internal.framework.module;

import Internal.framework.controller.interest.interestCalculators.InterestCalculatorsRateEnum;

public class SilverInterest extends InterestCalculator {

    @Override
    public double calculateInterest(Account account) {
        return account.getBalance()* InterestCalculatorsRateEnum.MISILVER.getValue();
    }

    @Override
    public double interestRateValue() {
        return InterestCalculatorsRateEnum.MISILVER.getValue();
    }

}
