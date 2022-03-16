package Internal.bank.ui;


import Internal.bank.CheckingAccount;
import Internal.framework.controller.interest.interestCalculators.CompanyCheckingInterestCalculator;
import Internal.framework.controller.interest.interestCalculators.PersonalCheckingInterestCalculator;
import Internal.framework.module.*;


public class CheckingAccountConcreteFactory extends AccountFactory {

    public String getAccountType() {
        return AccountType.CHECKING.name();
    }


    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        if (customer.getCustomerType() == CustomerType.COMPANY)
            return new CheckingAccount(customer, accountNumber, new CompanyCheckingInterestCalculator());
        else
            return new CheckingAccount(customer, accountNumber, new PersonalCheckingInterestCalculator());

    }
}
