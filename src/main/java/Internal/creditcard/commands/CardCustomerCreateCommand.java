package Internal.creditcard.commands;

import Internal.framework.controller.AccountServiceApplicationFactory;
import Internal.framework.module.Customer;
import Internal.framework.module.Individual;
import Internal.framework.module.commands.CommandInterface;

import javax.imageio.stream.ImageInputStream;

public class CardCustomerCreateCommand implements CommandInterface {
    private final AccountServiceApplicationFactory service;

    private Customer customer;

    public CardCustomerCreateCommand(AccountServiceApplicationFactory service) {
        this.service = service;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setParams(String... args) {
        customer = new Individual();
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
