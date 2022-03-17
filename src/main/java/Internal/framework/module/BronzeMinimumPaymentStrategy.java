package Internal.framework.module;

import Internal.framework.controller.interest.interestCalculators.InterestCalculatorsRateEnum;

public class BronzeMinimumPaymentStrategy implements MinimumPaymentStrategy {
    @Override
    public double calculateMinimumPayment(double balance) {
        return InterestCalculatorsRateEnum.MPBRONZE.getValue()* balance;
    }

    @Override
    public double MinimumPaymentRateValue() {
        return InterestCalculatorsRateEnum.MPBRONZE.getValue();
    }
}
