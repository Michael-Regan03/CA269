import java.util.Map;

interface Activity {
    public Person getPerson();
    public StreamObject getStreamObject();
    Map<String,Person> getAudience();
    String getURI();
}

/* receives a message and adds it to the Inbox */
interface ReceiveMessage {
    // returns a success / failure message
    boolean receive(Activity activity);
}

/* removes and retrieves the next message from inbox */
interface ReadNextMessage {
    // returns an Activity, or null if there are no messages
    Activity readNext();
}

/* provides inbox functionality */
interface Inbox extends ReceiveMessage, ReadNextMessage {
    // returns count of unread messages in inbox

    int getCount();
}

/* sends a message and adds it to the Outbox */
interface SendMessage {
    boolean send(Activity activity);
}

/* removes and delivers the next message from inbox */
interface DeliverNextMessage {
    // returns an Activity, or null if there are no messages
    Activity deliverNext();
}

/* provides outbox functionality */
interface Outbox extends SendMessage, DeliverNextMessage {
    // returns count of unsent messages in outbox
    int getCount();
}

/* the client App that handles inboxes and outboxes */
interface App {
    Inbox1 getInbox(); // retrieves the inbox
    Outbox1 getOutbox(); // retrieves the outbox
    String demo(); // prints a demo of the app in action
}