package Internal.bank;

import Internal.bank.CheckingAccount;
import Internal.bank.SavingAccount;
import Internal.framework.controller.AccountService;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.module.*;
import Internal.framework.ui.ApplicationFrm;

import javax.swing.*;

public class BankServiceAplication extends AccountServiceApplicationFactory {
    @Override
    public void init(EnvironmentType envType) {
        setEnvType(envType);
    }

    @Override
    public void createCommands(ApplicationFrm form, AccountServiceApplicationFactory service) {
        form.setCommand(0, new DepositCommand(service));
        form.setCommand(1, new WidthdrawCommand(service));
        form.setCommand(2, new AddInterestCommand(service));
    }


    public static void main(String[] args) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            //Create a new instance of our application's frame, and make it visible.
            ApplicationFrm form = new ApplicationFrm();
            AccountServiceApplicationFactory service = new BankServiceAplication();
            service.createCommands(form, service);
            service.init(EnvironmentType.MEMORY);
            form.setAccountService(service);
            form.setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }


    }

    @Override
    public Account createAccount(AccountType type, String accountNumber, String customerName) {
        //setup environment
        super.setEnvType(EnvironmentType.MEMORY);

        //setInterest type
        Customer customer = super.getStorage().getCustomerDAO().loadCustomer(customerName);
        if (customer != null) {
            Account account;
            //TODO set interest value depending on type of account
            if (customer instanceof Individual) {
                if (type == AccountType.CHECKING) {
                    //account.setInterest(new PersonalCheckingInterestCalculator());
                    return new CheckingAccount(customer, accountNumber);

                }
                //  account.setInterest(new PersonalSavingInterestCalculator());
                return new SavingAccount(customer, accountNumber);
            }
            if (type == AccountType.CHECKING) {
                return new CheckingAccount(customer, accountNumber);
            }
            return new SavingAccount(customer, accountNumber);
        }

        return null;

    }


}
