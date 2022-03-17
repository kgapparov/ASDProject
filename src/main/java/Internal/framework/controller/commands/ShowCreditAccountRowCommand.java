package Internal.framework.controller.commands;

import Internal.creditcard.ui.CardFrm;
import Internal.framework.model.Account;
import Internal.framework.model.Company;

public class ShowCreditAccountRowCommand implements CommandInterface {
    private CardFrm form;

    public ShowCreditAccountRowCommand(CardFrm form) {
        this.form = form;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setParams(String... args) {

    }

    @Override
    public void execute() {
        Object[] rowdata = new Object[8];
        //clear row
        while (form.getModel().getRowCount() > 0) {
            form.getModel().removeRow(0);
        }
        //add all account data again
        for (Account account :form.getAccountService().getAllAccounts()) {
            System.out.println(account.getCustomer().getClientName());
            rowdata[0] = account.getCustomer().getClientName();
            rowdata[1] = account.getAccountNumber();
            if (account.getCustomer() instanceof Company)
                rowdata[2] = ((Company)account.getCustomer()).getExpireDate();
            rowdata[3] = account.getAccountType().toString();
            rowdata[4] = String.valueOf(account.getBalance());
            form.getModel().addRow(rowdata);
        }
    }
}
