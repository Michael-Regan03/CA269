
import java.util.Queue;
import java.util.LinkedList;
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * Inbox1 implements inbox and is a storage associated with a person where activities are sent to be received and acted upon by the Person. Activities are received through the method receive() and are stored in the queue messages.
 * Activities are popped off the queue in readNext() and a message is printed to console. Activities are then handled in response() where the are checked to determine which specific ancestor of activity they are and 
 * then the activities functionality is implemented.
 */
class Inbox1 implements Inbox{
    /**
     * A queue of Activities
     */
    Queue<Activity> messages = new LinkedList<Activity>();
    
    /**
     * @param activity Activity send to the inbox to be stored in messages
     */
    public boolean receive(Activity activity) {
        try {
            this.messages.add(activity);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    /**
     * Pops an activity of of message and prints a message
     * @return next activity in messages
     */
    public Activity readNext() {
        if (messages.isEmpty()) {
            return null;
        }
        Activity activity = this.messages.remove();
        System.out.println("-" + activity.getURI() + "\n");
        return activity;    
    }
    
    /**
     * returns number of activities stored in messages
     */
    public int getCount() {
       return this.messages.size();
    }
    
    /**
     * @param activity Activity to be handles
     * If activity is an instance of LikeActivity we update the streamObjects likes and print a message
     * If activity is an instance of CreateActivity and its deleted status is false we print its information in console
     * If activity is an instance of UnfollowActivity we update our followers and print a message
     * If activity is an instance of FollowActivity we update our followers and print a message.
     * If activity is an instance of DeleteActivity we get a print a message staying the sender deleted that streamObject.
     */
    public void response(Activity activity) {
       if (activity instanceof LikeActivity) {
            LikeActivity likeActivity = (LikeActivity) activity;
            likeActivity.getStreamObject().addLike(likeActivity.getPerson());
            System.out.println("-" + activity.getURI() + " liked your post\n");
        }else if(activity instanceof CreateActivity){
            CreateActivity createActivity = (CreateActivity) activity;
            if(!createActivity.getStreamObject().getDeletedStatus()){
                System.out.println("-load " + activity.getURI() + "\n");
            }
        } if (activity instanceof UnfollowActivity) {
            FollowActivity createActivity = (FollowActivity) activity;
            Person follower = createActivity.getPerson();
            createActivity.getPerson2().removeFollowers(follower);
            System.out.println("-unadded " + follower.getPreferredUsername() + " from follower list\n");
        }else if(activity instanceof FollowActivity){
            FollowActivity createActivity = (FollowActivity) activity;
            Person follower = createActivity.getPerson();
            createActivity.getPerson2().addFollowers(follower);
            System.out.println("-added " + follower.getPreferredUsername() + " to follower list\n");
        }else if(activity instanceof DeleteActivity){
            DeleteActivity deleteActivity = (DeleteActivity) activity;
            System.out.println("-" + deleteActivity.getPerson().getName() + " deleted " + deleteActivity.getStreamObject().getName() + "\n");
        }
        
    }
}
    

