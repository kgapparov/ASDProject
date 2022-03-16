package Internal.framework.module;

public class BronzeInterest extends InterestCalculator {


    @Override
    public double calculateInterest(Account account) {

        return account.getBalance()* 0.10;
    }


    @Override
    public double calculateBalance(double prevBalance, double totalCredit, double totalCharge) {
        return prevBalance - totalCredit + totalCharge + 0.1 * (prevBalance - totalCredit);
    }

}
