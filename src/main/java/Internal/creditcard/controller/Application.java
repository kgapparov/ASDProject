package Internal.creditcard.controller;

import Internal.creditcard.ui.CardFrm;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.module.BankEmailSender;

public class Application {
    public static void main(String[] args) {
        AccountServiceApplicationFactory application = new CreditCardApplication();
        application.registerObserver(new BankEmailSender());
        CardFrm form = new CardFrm();
        application.run(application, form);
    }

}
