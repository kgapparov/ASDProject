package Internal.framework.module;

public class BronzeInterest extends InterestCalculator {


    @Override
    public double calculateInterest(Account account) {

        return account.getBalance()* 0.10;
    }


}
