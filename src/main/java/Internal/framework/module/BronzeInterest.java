package Internal.framework.module;

public class BronzeInterest implements Interest {
    @Override
    public double getInterest(double balance) {
        return balance * 0.1;
    }
}
