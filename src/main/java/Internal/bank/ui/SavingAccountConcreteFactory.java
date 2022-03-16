package Internal.bank.ui;


import Internal.bank.CheckingAccount;
import Internal.bank.SavingAccount;
import Internal.framework.controller.interestCalculators.CompanyCheckingInterestCalculator;
import Internal.framework.controller.interestCalculators.CompanySavingInterestCalculator;
import Internal.framework.controller.interestCalculators.PersonalCheckingInterestCalculator;
import Internal.framework.controller.interestCalculators.PersonalSavingInterestCalculator;
import Internal.framework.module.*;


public class SavingAccountConcreteFactory extends AccountFactory {

    public String getAccountType() {
        return AccountType.CHECKING.name();
    }


    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        if (customer.getCustomerType() == CustomerType.COMPANY)
            return new SavingAccount(customer, accountNumber, new CompanySavingInterestCalculator());
        else
            return new SavingAccount(customer, accountNumber, new PersonalSavingInterestCalculator());

    }
}
