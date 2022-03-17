package Internal.creditcard.controller;

import Internal.creditcard.ui.CardFrm;
import Internal.framework.controller.factory.AccountServiceApplicationFactory;
import Internal.framework.controller.observer.CreditCardEmailSender;

public class Application {
    public static void main(String[] args) {
        AccountServiceApplicationFactory application = new CreditCardApplication();
        application.registerObserver(new CreditCardEmailSender());
        CardFrm form = new CardFrm();
        application.run(application, form);
    }

}
