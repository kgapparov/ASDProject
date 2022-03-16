package Internal.framework.controller.interest.intereststate;

public enum InterestRateEnum {
    LOWINTEREST(0.1) ,
    MIDINTEREST(0.2),
    HIGHINTEREST(0.3);

    private double value;

    public double getValue() {
        return value;
    }

    InterestRateEnum(double v) {
        this.value = v;
    }

}
