package Internal.creditcard.model;

import Internal.framework.controller.interest.interestCalculators.InterestCalculatorsRateEnum;

public class GoldMinimumPaymentStrategy implements MinimumPaymentStrategy {
    @Override
    public double calculateMinimumPayment(double balance) {
        return InterestCalculatorsRateEnum.MPGOLD.getValue() * balance;
    }

    @Override
    public double MinimumPaymentRateValue() {
        return InterestCalculatorsRateEnum.MPGOLD.getValue();
    }
}

