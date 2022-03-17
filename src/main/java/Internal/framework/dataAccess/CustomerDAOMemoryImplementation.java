package Internal.framework.dataAccess;

import Internal.framework.model.Customer;

import java.util.Collection;

public class CustomerDAOMemoryImplementation implements CustomerDAO{
    private final CommonDAO<Customer> memCustomer= new CommonDAOMemoryImplement<Customer>();

    @Override
    public void saveCustomer(Customer customer) {
        memCustomer.save(customer.getClientName(), customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        memCustomer.update(customer.getClientName(), customer);
    }

    @Override
    public Customer loadCustomer(String customerNumber) {
        return memCustomer.loadData(customerNumber);
    }
    @Override
    public Collection<Customer> getCustomers() {
        return memCustomer.getAll();
    }
}
