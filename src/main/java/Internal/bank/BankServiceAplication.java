package Internal.bank;

import Internal.bank.ui.CheckingAccountConcreteFactory;
import Internal.bank.ui.SavingAccountConcreteFactory;
import Internal.creditcard.controller.CompanyConcreteFactory;
import Internal.creditcard.controller.PersonalConcreteFactory;
import Internal.creditcard.ui.CardFrm;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.module.Account;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Customer;
import Internal.framework.module.commands.*;
import Internal.framework.controller.command.*;
import Internal.framework.module.*;
import Internal.framework.ui.ApplicationFrm;

import java.time.LocalDate;

public class BankServiceAplication extends AccountServiceApplicationFactory {

    @Override
    public void createCommands(CardFrm form, AccountServiceApplicationFactory service) {

    }

    @Override
    public void init(EnvironmentType envType) {
        setEnvType(envType);
    }


    @Override
    public void createCommands(ApplicationFrm form, AccountServiceApplicationFactory service) {
        form.getInvoker().setCommand(0, new DepositCommand(service));
        form.getInvoker().setCommand(1, new WidthdrawCommand(service));
        form.getInvoker().setCommand(2, new AddInterestCommand(service));
        form.getInvoker().setCommand(3, new AddCustomerCommand(service));
        form.getInvoker().setCommand(4, new ReportCommand(service));
        form.getInvoker().setCommand(5, new ShowAccountRowCommand(form));
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
    }


    @Override
    public String buildReport() {
        String billstring = "";
        LocalDate todaydate = LocalDate.now();
        for (Account account : getAllAccounts()) {
            Customer cust = account.getCustomer();
            System.out.println("----------------------------------------");
            billstring += String.format("Name= %s\r\n", cust.getClientName());
            billstring += String.format("Address= %s, %s, %s, %s\r\n", cust.getStreet(), cust.getCity(), cust.getState(), cust.getZip());
            billstring += String.format("CC number= %s\r\n", account.getAccountNumber());
            billstring += String.format("CC type= %s\r\n", account.getAccountType());
            billstring += String.format("Account balance = $ %f\r\n", account.getBalance());
            billstring += "==================================\n";
            billstring += ("-Date-----"
                    + "-Description--"
                    + "-Amount---\n");
            for (AccountEntry entry : account.getEntryList()) {
                billstring += String.format("%10s%10s%10.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            billstring += "\n----------------------------------------\n";
            billstring += String.format("%10s%10s%10.2f\n\n", "", "Current Balance:", account.getBalance());
        }
        System.out.println(billstring);
        return billstring;
    }
}



