package Internal.framework.controller.commands;

import Internal.framework.controller.factory.AccountServiceApplicationFactory;

public class AddInterestCommand implements CommandInterface {

    private AccountServiceApplicationFactory serviceApplicationFactory;

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public AddInterestCommand(AccountServiceApplicationFactory serviceApplicationFactory) {
        this.serviceApplicationFactory = serviceApplicationFactory;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setParams(String... args) {

    }

    @Override
    public void execute() {
        serviceApplicationFactory.addInterest();
    }
}
