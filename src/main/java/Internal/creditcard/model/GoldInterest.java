package Internal.creditcard.model;

import Internal.framework.controller.interest.interestCalculators.InterestCalculatorsRateEnum;
import Internal.framework.model.Account;
import Internal.framework.model.InterestCalculator;

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

