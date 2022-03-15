package Internal.framework.module;

public class SilverInterest implements Interest {
    @Override
    public double getInterest(double balance) {
        return balance * 0.08;
    }
}
