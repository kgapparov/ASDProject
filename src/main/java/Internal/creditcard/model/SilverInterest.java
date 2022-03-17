package Internal.creditcard.model;

import Internal.framework.controller.interest.interestCalculators.InterestCalculatorsRateEnum;
import Internal.framework.model.Account;
import Internal.framework.model.InterestCalculator;

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
