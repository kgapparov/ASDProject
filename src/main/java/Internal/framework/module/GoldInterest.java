package Internal.framework.module;

public class GoldInterest implements Interest {
    @Override
    public double getInterest(double balance) {
        return balance * 0.06;
    }
}

