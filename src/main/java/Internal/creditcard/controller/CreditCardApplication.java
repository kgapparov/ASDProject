package Internal.creditcard.controller;

import Internal.creditcard.ui.CardFrm;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.controller.command.ReportCommand;
import Internal.framework.dataAccess.BronzeCreditCardFactory;
import Internal.framework.dataAccess.GoldCreditCardFactory;
import Internal.framework.dataAccess.SilverCreditCardFactory;
import Internal.framework.module.*;
import Internal.framework.module.commands.*;
import Internal.framework.ui.ApplicationFrm;

import java.time.LocalDate;

public class CreditCardApplication extends AccountServiceApplicationFactory {
    @Override
    public void createCommands(ApplicationFrm form, AccountServiceApplicationFactory service) {

    }

    @Override
    public void createCommands(CardFrm form, AccountServiceApplicationFactory service) {
    }

    @Override
    public void init(EnvironmentType envType) {
        setEnvType(envType);
    }

    @Override
    public Account createConcreteAccount(AccountType accountType, Customer customer, String accountNumber) {
        if (accountType == AccountType.SILVER)
            return new SilverCreditCardFactory().createAccount(accountNumber, customer);
        else if (accountType == AccountType.GOLDEN)
            return new GoldCreditCardFactory().createAccount(accountNumber, customer);
        return new BronzeCreditCardFactory().createAccount(accountNumber, customer);
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