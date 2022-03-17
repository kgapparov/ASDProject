package Internal.framework.module;

public class BronzeMinimumPaymentStrategy implements MinimumPaymentStrategy {
    @Override
    public double calculateMinimumPayment(double balance) {
        return 0.14 * balance;
    }

    @Override
    public double MinimumPaymentRateValue() {
        return 0.14;
    }
}
