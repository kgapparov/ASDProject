package Internal.framework.module;

public class Company extends Customer{
    private int noOfEmployees;
    private int expireDate;

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    public Company() {
        super();
        super.setCustomerType(CustomerType.COMPANY);
    }
}
