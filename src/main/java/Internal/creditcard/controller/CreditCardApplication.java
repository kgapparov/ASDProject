package Internal.creditcard.controller;

import Internal.creditcard.model.CreditCardAccount;
import Internal.creditcard.ui.CardFrm;
import Internal.framework.controller.factory.AccountServiceApplicationFactory;
import Internal.framework.model.EnvironmentType;
import Internal.framework.controller.factory.CompanyConcreteFactory;
import Internal.framework.controller.factory.PersonalConcreteFactory;
import Internal.framework.model.*;
import Internal.bank.ui.ApplicationFrm;

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

        Account account;
        if (customer.getCustomerType() == CustomerType.COMPANY) {
            account = new CompanyConcreteFactory().createAccount(accountType,accountNumber, customer);

        } else {
            account = new PersonalConcreteFactory().createAccount(accountType,accountNumber, customer);

        }
        getAccountDAO().saveAccount(account);
        return account;
      /*
        Account account;
        if (accountType == AccountType.SILVER)
            account = new SilverCreditCardFactory().createAccount(accountNumber, customer);
        else if (accountType == AccountType.GOLDEN)
            account = new GoldCreditCardFactory().createAccount(accountNumber, customer);
        else
        account = new BronzeCreditCardFactory().createAccount(accountNumber, customer);
        getAccountDAO().saveAccount(account);
        return account;*/
    }

    @Override
    public String buildReport() {
        String billstring = " Credit card report \n";
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
            billstring += String.format("Name= %s\r\n", cust.getClientName());
            billstring += String.format("Address= %s, %s, %s, %s\r\n", cust.getStreet(), cust.getCity(), cust.getState(), cust.getZip());
            billstring += String.format("CC number= %s\r\n", account.getAccountNumber());
            billstring += String.format("CC type= %s\r\n", account.getAccountType());
            billstring += String.format("Previous balance = $ %f\r\n", prevBalance);
            billstring += String.format("Total Credits = $ %f\r\n", totalCredit);
            billstring += String.format("Total Charges = $ %f\r\n", totalCharge);
            billstring += String.format("New balance = $ %f\r\n", newBalance);
            billstring += String.format("Total amount due = $ %f\r\n", totalDue);
            billstring += "\r\n";
            billstring +="------------------------------------------------\n";

        }
        if(!hasdata)
            billstring += "\n empty report";


        //System.out.println(billstring);
        return billstring;
    }

}