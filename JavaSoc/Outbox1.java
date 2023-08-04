
import java.util.Queue;
import java.util.LinkedList;
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * Outbox1 implements Outbox and is storage associated with a person where activities are sent. Activities are created by a user and then stored in the queue messages using send(). deliveredNext() will then push 
 * Activities out of messages and deliver them in the inbox's of the people in the Activities audience. A message will be printed to terminal when send() and deliverNext() are called.
 */
class Outbox1 implements Outbox{
    /**
     * A queue of Activities
     */
    Queue<Activity> messages = new LinkedList<Activity>();

    /**
     * Will store the activity in messages and then print out the activities toString() method
     * @param activity The activity being sent to the outbox
     * @return returns true if activity was successfully stored and toSTring() method was printed else return false  
     */
    public boolean send(Activity activity) {
        try {
            messages.add(activity);
            System.out.println(activity.toString());
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * Pops an activity off the queue messages and sends it to the audience's inboxes
     */
    public Activity deliverNext() {
        Activity next = this.messages.remove();
        sendToInbox(next);
        return next;
    }

    /**
     * @return The number of activities in messages
     */
    public int getCount() {
        return this.messages.size();
    }
    
    /**
     * Prints message to signify a successful post
     * Iterates through the people of the audience of the activity being sent and updates there inboxes
     * @param activity The activity being sent
     */
    public void sendToInbox(Activity activity){
        System.out.println("-" + activity.getURI()+" posted\n");
        for(Person people: activity.getAudience().values()) {
            people.getInbox().receive(activity);
        }
    }
}