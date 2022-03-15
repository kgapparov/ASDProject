package Internal.framework.dataAccess;

public class MemoryStorageFactory extends StorageFactory{
    public MemoryStorageFactory(){
        super();
        super.setAccountDAO(new AccountDAOMemoryImplementation());
        super.setAccountEntryDAO(new AccountEntryDAOMemoryImplementation());
        super.setCustomerDAO(new CustomerDAOMemoryImplementation());
    }
}
