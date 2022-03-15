package Internal.framework.module;

public class SilverMinimumPaymentStrategy implements MinimumPaymentStrategy {
    @Override
    public double calculateMinimumPayment(double balance) {
        return 0.12 * balance;
    }
}
