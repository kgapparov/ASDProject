package Internal.framework.module;

public class GoldMinimumPaymentStrategy implements MinimumPaymentStrategy {
    @Override
    public double calculateMinimumPayment(double balance) {
        return 0.1 * balance;
    }

    @Override
    public double MinimumPaymentRateValue() {
        return 0.1;
    }
}

