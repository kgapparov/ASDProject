package Internal.framework.module;

import Internal.framework.controller.interest.interestCalculators.InterestCalculatorsRateEnum;

public class BronzeInterest extends InterestCalculator {


    @Override
    public double calculateInterest(Account account) {

        return account.getBalance()* InterestCalculatorsRateEnum.MIBRONZE.getValue();
    }

    @Override
    public double interestRateValue() {
        return InterestCalculatorsRateEnum.MIBRONZE.getValue();
    }


}
