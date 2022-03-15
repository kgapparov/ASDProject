package Internal.framework.module;

import java.time.LocalDate;
import java.util.List;

public class MonthlyAccountReport extends Report {
    private double previousBalance;
    private double totalCharges;
    private double totalCredits;
    private double newBalance;
    private double totalDue;

    public MonthlyAccountReport(String customerName, String customerEmail, double balance, String type, LocalDate date,
                                List<AccountEntry> entryList, double previousBalance, double totalCharges,
                                double totalCredits, double newBalance, double totalDue) {
        super(customerName, customerEmail, balance, type, date, entryList);
        this.previousBalance = previousBalance;
        this.totalCharges = totalCharges;
        this.totalCredits = totalCredits;
        this.newBalance = newBalance;
        this.totalDue = totalDue;
    }

    @Override
    public String toString() {
        return "MonthlyAccountReport{" +
                "Customer Name = " + getCustomerName() +
                "Email = " + getCustomerEmail() +
                ", previousBalance=" + previousBalance +
                ", totalCharges=" + totalCharges +
                ", totalCredits=" + totalCredits +
                ", newBalance=" + newBalance +
                ", totalDue=" + totalDue +
                '}';
    }
}
