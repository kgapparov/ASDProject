package Internal.framework.dataAccess;

import Internal.framework.model.Customer;

import java.util.Collection;

public interface CustomerDAO {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer loadCustomer(String customerNumber);
    Collection<Customer> getCustomers();
}
