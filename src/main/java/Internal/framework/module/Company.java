package Internal.framework.module;

public class Company extends Customer{
    private int noOfEmployees;

    public Company() {
        super();
        super.setCustomerType(CustomerType.COMPANY);
    }
}
