package Internal.creditcard.model;

public interface MinimumPaymentStrategy {
    double calculateMinimumPayment(double balance);

    default public  double newBalanceCalculate(double prevBalance, double totalCredit, double totalCharge, double mi){
        return prevBalance - totalCredit + totalCharge +mi * (prevBalance - totalCredit);
    }

    public double MinimumPaymentRateValue();

}
