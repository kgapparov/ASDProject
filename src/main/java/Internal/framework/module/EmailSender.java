package Internal.framework.module;

public class EmailSender implements Observer{
    StateNotifyer subject;

    public EmailSender(StateNotifyer subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(Account account) {
        System.out.println("Sending an email to - " + account.getCustomer().getClientName());
    }
}
