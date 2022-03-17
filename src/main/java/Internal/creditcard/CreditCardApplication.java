package Internal.creditcard;

import Internal.bank.ui.CheckingAccountConcreteFactory;
import Internal.bank.ui.SavingAccountConcreteFactory;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.controller.interest.interestCalculators.PersonalCheckingInterestCalculator;
import Internal.framework.module.*;
import Internal.framework.ui.ApplicationFrm;

import java.time.LocalDate;

public class CreditCardApplication extends AccountServiceApplicationFactory {
    public CreditCardApplication() {

    }

    @Override
    public void createCommands(ApplicationFrm form, AccountServiceApplicationFactory service) {

    }

    @Override
    public void init(EnvironmentType envType) {
        setEnvType(envType);

    }

    @Override
    public Account createConcreteAccount(AccountType accountType, Customer customer, String accountNumber) {
        if(accountType == AccountType.BRONZE)
        {
            return new BronzeAccount(customer,accountNumber,new PersonalCheckingInterestCalculator());

        }else{
            return new SavingAccountConcreteFactory().createAccount(accountNumber,customer);

        }
    }

    @Override
    public String buildReport() {
        String billstring = "Credit card report";
        LocalDate todaydate = LocalDate.now();
        boolean hasdata = false;
        for (Account account : getAllAccounts()) {
            hasdata = true;
            Customer cust = account.getCustomer();
            CreditCardAccount act = (CreditCardAccount) account;
            double prevBalance = act.getPrevBalance();
            double totalCredit = act.getTotalCredit();
            double totalCharge = act.getTotalCharge();
            double newBalance = act.getNewBalance();
            double totalDue = act.getTotalDue();
            billstring = String.format("Name= %s\r\n", cust.getClientName());
            billstring += String.format("Address= %s, %s, %s, %s\r\n", cust.getStreet(), cust.getCity(), cust.getState(), cust.getZip());
            billstring += String.format("CC number= %s\r\n", account.getAccountNumber());
            billstring += String.format("CC type= %s\r\n", account.getAccountType());
            billstring += String.format("Previous balance = $ %f\r\n", prevBalance);
            billstring += String.format("Total Credits = $ %f\r\n", totalCredit);
            billstring += String.format("Total Charges = $ %f\r\n", totalCharge);
            billstring += String.format("New balance = $ %f\r\n", newBalance);
            billstring += String.format("Total amount due = $ %f\r\n", totalDue);
            billstring += "\r\n";
            billstring += "\r\n";
        }
        if(!hasdata)
            billstring += "\n empty report";

        //System.out.println(billstring);
        return billstring;
    }

}