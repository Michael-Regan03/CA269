
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * UnfollowActivity preforms the unfollowing action whereby the sender removes person2 from their following and person2 removes person1 from their followers
 */
 public class UnfollowActivity extends FollowActivity{
    Person person2;
    /**
    Constructs an UnfollowActivity object with the given person1 and person2 parameters.
    @param person1 The person who is performing the unfollowing action.
    @param person2 The person who is being unfollowed.
    */
    UnfollowActivity(Person person1, Person person2){
        super(person1,person2);
    }
    /**
    @return A String representation of the UnfollowActivity object.
    */
    public String toString(){
        return "-URI: " + getURI() + "\n-Unfollower: "  + getPerson().getPreferredUsername() + "\n-Unfollowing: " + getPerson2().getPreferredUsername() + "\n";
    }

    /*
     * remove's person2 from person1's following list
     */
    public void updateFollowing(){
        getPerson().removeFollowing(getPerson2());
    }
}