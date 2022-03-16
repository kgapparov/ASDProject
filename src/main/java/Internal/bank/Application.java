package Internal.bank;

import Internal.bank.ui.BankApplicationForm;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.module.commands.CommandInterface;
import Internal.framework.ui.ApplicationFrm;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        BankServiceAplication application = new BankServiceAplication();
        ApplicationFrm form = new BankApplicationForm();
        application.run(application, form);


    }

}
