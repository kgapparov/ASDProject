package Internal.framework.module;

import java.time.LocalDate;
import java.util.List;

public class Report {
    private String customerName;
    private String customerEmail;
    private double balance;
    private String type;
    private LocalDate date;
    private List<AccountEntry> entryList;

    public Report(String customerName, String customerEmail, double balance, String type, LocalDate date,List<AccountEntry> entryList) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.balance = balance;
        this.type = type;
        this.date = date;
        this.entryList = entryList;
    }

    public List<AccountEntry> getEntryList() { return entryList; }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    @Override
    public String toString() {
        return "Report{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}'+"\n";
    }
}
