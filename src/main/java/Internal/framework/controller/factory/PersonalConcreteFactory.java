package Internal.framework.controller.factory;


import Internal.bank.model.CheckingAccount;
import Internal.bank.model.SavingAccount;
import Internal.creditcard.model.*;
import Internal.framework.controller.interest.interestCalculators.PersonalCheckingInterestCalculator;
import Internal.framework.controller.interest.interestCalculators.PersonalSavingInterestCalculator;
import Internal.framework.model.*;


public class PersonalConcreteFactory extends AccountFactory {

    public String getAccountType() {
        return AccountType.CHECKING.name();
    }



    @Override
    public Account createAccount(AccountType accountType, String accountNumber, Customer customer) {


        if (accountType == AccountType.SILVER)
            return new SilverAccount(customer, accountNumber, new SilverInterest(), new SilverMinimumPaymentStrategy());
        else if (accountType == AccountType.BRONZE)
            return new BronzeAccount(customer, accountNumber, new BronzeInterest(), new BronzeMinimumPaymentStrategy());
        else if (accountType == AccountType.GOLDEN)
            return new GoldAccount(customer, accountNumber, new GoldInterest(), new GoldMinimumPaymentStrategy());
        else if (accountType == AccountType.CHECKING)
            return new CheckingAccount(customer, accountNumber, new PersonalCheckingInterestCalculator());
        else if (accountType == AccountType.SAVING)
            return new SavingAccount(customer, accountNumber, new PersonalSavingInterestCalculator());

        else return null;

    }
}
