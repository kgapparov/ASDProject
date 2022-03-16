package Internal.bank;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.module.Account;
import Internal.framework.module.AccountType;
import Internal.framework.module.Customer;
import Internal.framework.module.Individual;
import Internal.framework.module.commands.AddInterestCommand;
import Internal.framework.module.commands.DepositCommand;
import Internal.framework.module.commands.WidthdrawCommand;
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
}
