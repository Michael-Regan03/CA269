
/**
 * @author Michael Regan Student ID: 
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * FollowActivity extends BasicActivity and is a follow action whereby the sender updates there following with the person they wish to follow and when that person receives that 
 * FollowingActivity in their inbox they update there followers.
 */
public class FollowActivity extends BasicActivity{
    Person person2;

    /**
     * Constructor for FollowActivity object
     * @param person1 Person sending the FollowActivity
     * @param person2 The Person the sender wishes to follow
    */
    FollowActivity(Person person1, Person person2){
        super(person1);
        setPerson2(person2);
        updateFollowing();
        setAudience(person);
    
    }


    public void setPerson2(Person person2){
        this.person2 = person2;
    }

    public Person getPerson2(){
        return this.person2;
    }

    public void setStreamObject(StreamObject streamObject){
        this.streamObject = streamObject;
    }

    public void setAudience(Person person){
        getAudience().put(getPerson2().getPreferredUsername(), getPerson2()); //setting the audience to the person being followed;
    }

    /**
     * @return A String representation of the UnfollowActivity object.
     */
    public String toString(){
        return "-URI: " + getURI() + "\n-follower: "  + getPerson().getPreferredUsername() + "\n-following: " + getPerson2().getPreferredUsername() + "\n";
    }

    public void updateFollowing(){
        getPerson().addFollowing(getPerson2());
    }
}