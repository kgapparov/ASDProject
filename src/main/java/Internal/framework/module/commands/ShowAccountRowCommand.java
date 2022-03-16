package Internal.framework.module.commands;

import Internal.framework.module.Account;
import Internal.framework.module.Company;
import Internal.framework.ui.ApplicationFrm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ShowAccountRowCommand implements CommandInterface {
    private ApplicationFrm form;

    public ShowAccountRowCommand(ApplicationFrm form) {
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
            rowdata[0] = account.getAccountNumber();
            rowdata[1] = account.getCustomer().getClientName();
            rowdata[2] = account.getCustomer().getCity();
            if (account.getCustomer() instanceof Company) {
                rowdata[3] = "C";
            } else {
                rowdata[3] = "P";
            }
            rowdata[4] = account.getAccountType().toString();
            rowdata[5] = String.valueOf(account.getBalance());
            form.getModel().addRow(rowdata);
        }
    }
}
