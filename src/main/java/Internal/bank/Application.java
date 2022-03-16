package Internal.bank;

import Internal.bank.ui.BankApplicationForm;
import Internal.creditcard.CreditCardApplication;
import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.module.CreditCardEmailSender;
import Internal.framework.module.EmailSender;
import Internal.framework.module.commands.CommandInterface;
import Internal.framework.ui.ApplicationFrm;
import Internal.ui.ccard.CardFrm;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        BankServiceAplication application = new BankServiceAplication();
        application.registerObserver(new EmailSender());
        ApplicationFrm form = new BankApplicationForm();
        application.run(application, form);


    }

}
