package Internal.bank;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.EnvironmentType;
import Internal.framework.ui.ApplicationFrm;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Create a new instance of our application's frame, and make it visible.
            ApplicationFrm form = new ApplicationFrm();
            AccountServiceApplicationFactory service = new BankServiceAplication();
            service.createCommands(form, service);
            service.init(EnvironmentType.MEMORY);
            form.setAccountService(service);
            form.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}
