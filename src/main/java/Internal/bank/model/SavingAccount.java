package Internal.bank.model;

 import Internal.framework.model.*;

public class SavingAccount extends Account {

    public SavingAccount(Customer customer, String accNum, InterestCalculator interestCalculator) {
        super(customer, accNum,interestCalculator);
    }


    public String getAccountType() {
        return AccountType.SAVING.name();
    }
}
