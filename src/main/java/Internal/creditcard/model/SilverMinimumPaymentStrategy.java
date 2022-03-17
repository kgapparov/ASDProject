package Internal.creditcard.model;

import Internal.framework.controller.interest.interestCalculators.InterestCalculatorsRateEnum;

public class SilverMinimumPaymentStrategy implements MinimumPaymentStrategy {
    @Override
    public double calculateMinimumPayment(double balance) {
        return InterestCalculatorsRateEnum.MPSILVER.getValue() * balance;
    }

    @Override
    public double MinimumPaymentRateValue() {
        return InterestCalculatorsRateEnum.MPSILVER.getValue();
    }
}
