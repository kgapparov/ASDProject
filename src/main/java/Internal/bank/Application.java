package Internal.bank;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.ui.ApplicationFrm;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        BankServiceAplication application = new BankServiceAplication();
        ApplicationFrm form = new ApplicationFrm();
        application.run(application, form);
    }
}
