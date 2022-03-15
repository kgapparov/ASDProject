package Internal.framework.dataAccess;

import Internal.framework.module.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MonthlyAccountReportFactory extends ReportFactory {
    private Account account;

    public MonthlyAccountReportFactory(Account account) {
        this.account = account;
    }

    @Override
    public Report createReport() {
        List<AccountEntry> entryList = account.getEntryList();
        double previousBalance = 0.0;
        double totalDeposit = 0.0;
        List<AccountEntry> totalWithdrawTransactions = account.getEntryList();

        double totalCharges = 0.0;
        double totalCredits = 0.0;
        double newBalance = 0.0;
        double paymentInterestRate = account.getInterest().getInterest(previousBalance);
        double totalDue = totalCredits * totalCredits;
        MonthlyAccountReport monthlyAccountReport = new MonthlyAccountReport(account.getCustomer().getClientName(),
                account.getCustomer().getClientName(), account.getBalance(), "Monthly Report", LocalDate.now(),
                entryList, previousBalance, totalCharges, totalCredits, newBalance, totalDue);
        return monthlyAccountReport;
    }
}
