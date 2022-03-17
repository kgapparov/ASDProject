package Internal.framework.controller.interest.interestCalculators;

public enum InterestCalculatorsRateEnum {
    MIGOLD(0.06) ,
    MISILVER(0.08),
    MIBRONZE(0.1),
    MPGOLD(0.1) ,
    MPSILVER(0.12),
    MPBRONZE(0.14);

    private double value;

    public double getValue() {
        return value;
    }

    InterestCalculatorsRateEnum(double v) {
        this.value = v;
    }

}
