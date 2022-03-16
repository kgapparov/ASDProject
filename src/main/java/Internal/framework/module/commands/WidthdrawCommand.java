package Internal.framework.module.commands;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.module.commands.CommandInterface;

public class WidthdrawCommand implements CommandInterface {
    private AccountServiceApplicationFactory service;
    private Double amount;
    private String accNumber, title;

    public void setTitle(String title) {
        this.title = title;
    }

    public WidthdrawCommand(AccountServiceApplicationFactory service ) {
        this.service = service;
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
        service.withdraw(accNumber, amount);
    }
}
