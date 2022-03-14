package Internal.dataAccess;

public abstract class Storage {
    private AccountDAO account;
    private AccountEntryDAO cccountEntry;
    private CustomerDAO customer;
    private AddressDAO address;

    public Storage getFacadeStorage(EnvironmentType type) {
    return null;
    }
}
