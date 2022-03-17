package Internal.bank.model;


  import Internal.framework.model.*;


public class CheckingAccount extends Account {
    public CheckingAccount(Customer customer, String accNum,InterestCalculator interestCalculator) {
        super(customer, accNum,interestCalculator);
    }

    public String getAccountType() {
        return AccountType.CHECKING.name();
    }


}
