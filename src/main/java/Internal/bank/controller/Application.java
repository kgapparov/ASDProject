package Internal.bank.controller;

import Internal.bank.ui.BankApplicationForm;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.module.BankEmailSender;
import Internal.framework.ui.ApplicationFrm;

public class Application {
    public static void main(String[] args) {
        AccountServiceApplicationFactory application = new BankServiceAplication();
        application.registerObserver(new BankEmailSender());
        ApplicationFrm form = new BankApplicationForm();
        application.run(application, form);




    }

}
