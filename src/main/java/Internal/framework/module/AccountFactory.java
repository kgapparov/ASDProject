package Internal.framework.module;

public abstract class AccountFactory {
    public abstract Account createAccount(String accountNumber, Customer customer);
}
