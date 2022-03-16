package Internal.bank.ui;

import Internal.framework.ui.ApplicationFrm;
import Internal.framework.ui.JDialogGenBill;

import java.awt.event.ActionEvent;

public class BankApplicationForm extends ApplicationFrm {
    javax.swing.JButton JButton_Report = new javax.swing.JButton();


    public BankApplicationForm(){
        super();
        JButton_Report.setBounds(468,210,96,33);
        JButton_Report.setText("Report");
        super.getJPanel1().add(JButton_Report);
        JButton_Report.addActionListener(new SymAction());
    }

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_Report) {
                JButton_Report_actionPerformed(event);
            }
        }
    }

    private void JButton_Report_actionPerformed(ActionEvent event) {
        JDialogGenBill bilFrm = new JDialogGenBill(this, super.getAccountService().buildReport());
        bilFrm.setBounds(450, 20, 400, 350);
        bilFrm.show();
    }

}
