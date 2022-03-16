package Internal.framework.module.commands;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.module.Company;
import Internal.framework.module.Customer;
import Internal.framework.module.Individual;

public class AddCustomerCommand implements CommandInterface{
    private final AccountServiceApplicationFactory service;

    public AddCustomerCommand(AccountServiceApplicationFactory service) {
        this.service = service;
    }
    private Customer customer;

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setParams(String... args) {
        if (args.length < 6)
            return;
        String clientName, city, zip, state, street;
        clientName  = args[1];
        city        = args[2];
        zip         = args[3];
        state       = args[4];
        street      = args[5];
        if (args[0].equals("I")) {
            customer = new Individual();
        } else {
            customer = new Company();
        }
        customer.setClientName(clientName);
        customer.setCity(city);
        customer.setZip(zip);
        customer.setState(state);
        customer.setStreet(street);
    }

    @Override
    public void execute() {
        for (Customer custom : service.getStorage().getCustomerDAO().getCustomers()) {
            if (custom.getClientName().equals(customer.getClientName()) && custom.getZip().equals(customer.getZip())) {
                return;
            }
        }
        service.getStorage().getCustomerDAO().saveCustomer(customer);
    }
}
