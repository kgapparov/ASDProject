package Internal.framework.controller.command;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.module.commands.CommandInterface;

public class ReportCommand implements CommandInterface {
    private   String title;
    AccountServiceApplicationFactory accountService;


    public ReportCommand(AccountServiceApplicationFactory service ) {
        this.accountService = service;
        this.title = "Report";
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
        accountService.buildReport();
    }
}