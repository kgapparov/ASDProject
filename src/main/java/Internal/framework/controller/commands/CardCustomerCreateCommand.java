package Internal.framework.controller.commands;

import Internal.framework.controller.factory.AccountServiceApplicationFactory;
import Internal.framework.model.Company;
import Internal.framework.model.Customer;
import Internal.framework.model.CustomerType;
import Internal.framework.model.Individual;

public class CardCustomerCreateCommand implements CommandInterface {
    private final AccountServiceApplicationFactory service;
    private CustomerType customerType;

    private Customer customer;

    public CardCustomerCreateCommand(AccountServiceApplicationFactory service, CustomerType customerType) {
        this.service = service;
        this.customerType = customerType;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setParams(String... args) {
       // if(args[5]== )
        if (customerType== CustomerType.INDIVIDUAL) {
            customer = new Individual();

        }else{
            customer = new Company();

        }
        String clientName, city, zip, state, street;
        clientName  = args[0];
        city        = args[1];
        zip         = args[2];
        state       = args[3];
        street      = args[4];
        customer.setClientName(clientName);
        customer.setCity(city);
        customer.setZip(zip);
        customer.setState(state);
        customer.setStreet(street);
        System.out.println("LDSJFLKDSJFLKSJDFLJSLDKJFL");
        System.out.println(customer.getClientName());
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
