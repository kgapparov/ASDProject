package Internal.framework.controller.factory;


import Internal.bank.CheckingAccount;
import Internal.framework.controller.interest.interestCalculators.CompanyCheckingInterestCalculator;
import Internal.framework.controller.interest.interestCalculators.CompanySavingInterestCalculator;
import Internal.framework.module.*;


public class CompanyConcreteFactory extends AccountFactory {

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
            return new CheckingAccount(customer, accountNumber, new CompanyCheckingInterestCalculator());
        else if (accountType == AccountType.SAVING)
            return new CheckingAccount(customer, accountNumber, new CompanySavingInterestCalculator());

        else return null;
    }
}
