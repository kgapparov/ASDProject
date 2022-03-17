package Internal.framework.model;

import java.util.Date;

public class Individual extends Customer{
    private Date birthDate;
    public Individual(){
        super();
        super.setCustomerType(CustomerType.INDIVIDUAL);
    }
}
