package Internal.framework.module;

public interface MinimumPaymentStrategy {
    double calculateMinimumPayment(double balance);

    default public  double calculateBalance(double prevBalance, double totalCredit, double totalCharge, double mi){
        return prevBalance - totalCredit + totalCharge +mi * (prevBalance - totalCredit);
    }

}
