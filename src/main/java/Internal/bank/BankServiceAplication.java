package Internal.bank;

import Internal.framework.controller.AccountService;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Customer;
import Internal.framework.module.Individual;
import Internal.framework.module.commands.AddCustomerCommand;
import Internal.framework.module.commands.AddInterestCommand;
import Internal.framework.module.commands.DepositCommand;
import Internal.framework.module.commands.WidthdrawCommand;
import Internal.framework.controller.command.*;
import Internal.framework.module.*;
import Internal.framework.ui.ApplicationFrm;

import javax.swing.*;
import java.time.LocalDate;

public class BankServiceAplication extends AccountServiceApplicationFactory {
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
    }



    @Override
    public Account createConcreteAccount(AccountType type, Customer customer, String accountNumber)
    {
        Account account;
        if (type == AccountType.SAVING) {
            account = new SavingAccount(customer, accountNumber);
        } else {
            account = new CheckingAccount(customer, accountNumber);
        }
        return account;
    }

    @Override
    public void buildReport() {
        String billstring = "";
        LocalDate todaydate = LocalDate.now();
        for (Account account : getAllAccounts()) {
            Customer cust = account.getCustomer();
            System.out.println("----------------------------------------" + "----------------------------------------");
            billstring = String.format("Name= %s\r\n", cust.getClientName());
            billstring += String.format("Address= %s, %s, %s, %s\r\n", cust.getStreet(), cust.getCity(), cust.getState(), cust.getZip());
            billstring += String.format("CC number= %s\r\n", account.getAccountNumber());
            billstring += String.format("CC type= %s\r\n", account.getAccountType());
            billstring += String.format("Account balance = $ %f\r\n", account.getBalance());
            System.out.println(billstring);
            billstring += String.format("==================================");
            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");
            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }


}



