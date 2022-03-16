package Internal.framework.module;

public class SilverInterest extends InterestCalculator {

    @Override
    public double calculateInterest(Account account) {
        return handleInterest(account)* 0.3;
    }

}
