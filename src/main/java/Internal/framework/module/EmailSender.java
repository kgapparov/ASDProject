package Internal.framework.module;

import java.sql.Timestamp;

public class EmailSender implements Observer{
    StateNotifyer subject;

    public EmailSender(StateNotifyer subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void update(Account account, ActionType action) {
        System.out.println("Sending an email to - " + account.getCustomer().getClientName());
    }
}
