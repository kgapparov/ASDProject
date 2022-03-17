package Internal.framework.controller.commands;

import Internal.framework.controller.factory.AccountServiceApplicationFactory;

public class DepositCommand implements CommandInterface {
    private AccountServiceApplicationFactory service;
    private Double amount;
    private String accNumber, title;

    public void setTitle(String title) {
        this.title = title;
    }

    public DepositCommand(AccountServiceApplicationFactory service ) {
        this.service = service;
        this.title = "Deposit";
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setParams(String... args) {
        if (args.length < 2)
            return;
        amount = Double.parseDouble(args[1]);
        accNumber = args[0];
    }
    @Override
    public void execute() {
        service.deposit(accNumber, amount);
    }
}
