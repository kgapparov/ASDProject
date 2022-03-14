package Internal.framework.dataAccess;

public class MemoryStorageFactory extends StorageFactory{
    public MemoryStorageFactory(){
        super();
        super.setAccount(new AccountDAOMemoryImplementation());
        super.setCccountEntry(new AccountEntryDAOMemoryImplementation());
        super.setCustomer(new CustomerDAOMemoryImplementation());
    }
}
