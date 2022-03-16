package Internal.framework.ui;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.controller.command.Invoker;
import Internal.framework.module.AccountType;
import Internal.framework.module.Company;
import Internal.framework.module.Customer;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ApplicationFrm extends javax.swing.JFrame{

    private AccountServiceApplicationFactory accountService;


    public void setAccountService(AccountServiceApplicationFactory accountService) {
        this.accountService = accountService;
    }


    Invoker invoker = new Invoker();

    public AccountServiceApplicationFactory getAccountService() {
        return accountService;
    }

    String accountnr;
    String clientName;
    String street;
    String city;
    String zip;
    String state;
    AccountType accountType;
    String clientType;
    public String amountDeposit;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    ApplicationFrm myframe;
    private Object rowdata[];

    public Invoker getInvoker() {
        return invoker;
    }

    public ApplicationFrm()
    {
        myframe = this;
        //todo check commands
        setTitle("Bank Application.");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(575,310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowdata = new Object[8];
        newaccount=false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

        JButton_PerAC.setText("Add personal account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24,20,192,33);
        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240,20,192,33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468,94,96,33);
        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Addinterest.setBounds(448,20,106,33);
        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);
        JButton_Withdraw.setBounds(468,154,96,33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468,248,96,31);

        JButton_PerAC.setActionCommand("jbutton");

        ApplicationFrm.SymWindow aSymWindow = new ApplicationFrm.SymWindow();
        this.addWindowListener(aSymWindow);
        ApplicationFrm.SymAction lSymAction = new ApplicationFrm.SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        JButton_Addinterest.addActionListener(lSymAction);

    }

    public JPanel getJPanel1() {
        return JPanel1;
    }

    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
    javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
    javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
    javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
    javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
    javax.swing.JButton JButton_Exit = new javax.swing.JButton();

    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(java.awt.event.WindowEvent event)
        {
            Object object = event.getSource();
            if (object == ApplicationFrm.this)
                ApplicationFrm_windowClosing(event);
        }
    }

    void ApplicationFrm_windowClosing(java.awt.event.WindowEvent event)
    {
        // to do: code goes here.

        ApplicationFrm_windowClosing_Interaction1(event);
    }

    void ApplicationFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_PerAC)
                JButtonPerAC_actionPerformed(event);
            else if (object == JButton_CompAC)
                JButtonCompAC_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);
            else if (object == JButton_Addinterest)
                JButtonAddinterest_actionPerformed(event);
        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
    {
        System.exit(0);
    }

    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
    {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

        Internal.framework.ui.JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount){

            //Execute Customer Save Command
            getInvoker().getCommand(3).setParams("I", clientName, city, zip, state, street);
            getInvoker().getCommand(3).execute();

            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "P";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }

    }

    void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
    {
		/*
		 construct a JDialog_AddCompAcc type object
		 set the boundaries and
		 show it
		*/

        Internal.framework.ui.JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount){
            // add row to table
            invoker.getCommand(3).setParams("C", clientName, city, zip,state,street);
            invoker.getCommand(3).execute();
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "C";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }

    }

    void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
    {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            Internal.framework.ui.JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr, invoker.getCommand(0));
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String)model.getValueAt(selection, 5);
            double currentamount = Double.parseDouble(samount);
            double newamount=currentamount+deposit;
            model.setValueAt(String.valueOf(newamount),selection, 5);
        }


    }

    void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
    {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            Internal.framework.ui.JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accnr);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            // compute new amount
            double deposit = Double.parseDouble(amountDeposit);
            String samount = (String)model.getValueAt(selection, 5);
            double currentamount = Double.parseDouble(samount);
            Double newamount=currentamount-deposit;
            model.setValueAt(String.valueOf(newamount),selection, 5);
            if (newamount <0){
                JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
            }
        }


    }

    void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
    {
        getInvoker().getCommand(2).execute();
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
        invoker.getCommand(5).execute();
    }

    public DefaultTableModel getModel() {
        return model;
    }

    static public void main(String args[])
    {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new ApplicationFrm()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}
