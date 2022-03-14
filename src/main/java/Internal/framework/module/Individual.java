package Internal.framework.module;

import java.util.Date;

public class Individual extends Customer{
    private Date birthDate;
    public Individual(){
        super();
        super.setCustomerType(CustomerType.INDIVIDUAL);
    }
}
