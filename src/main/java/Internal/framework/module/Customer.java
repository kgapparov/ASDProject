package Internal.framework.module;

import java.util.Collection;
import java.util.LinkedList;

public abstract class Customer {
    private String clientName,street,city,zip,state,accountType, email;

    private CustomerType customerType;

    private Collection<Account> accounts;

    public Customer() {
        accounts = new LinkedList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
