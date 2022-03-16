package Internal.bank;


  import Internal.framework.module.*;


public class CheckingAccount extends Account {
    public CheckingAccount(Customer customer, String accNum,InterestCalculator interestCalculator) {
        super(customer, accNum,interestCalculator);
    }

    public String getAccountType() {
        return AccountType.CHECKING.name();
    }


}
