
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * LikeActivity extends BasicActivity preforms a like action whereby a person likes a streamObject.
 */
public class LikeActivity extends BasicActivity{

    /**
     * Constructor of LikeActivity object
     * @param person Person who likes the streamObject
     * @param activity Activity that contains the streamObject being liked.
     */
    LikeActivity(Person person, Activity activity){
        super(person);
        setStreamObject(activity.getStreamObject());
        setAudience(person);
        //person.liked.put(streamObject.name,streamObject);
    }

    public String toString() {
        return getPerson().getName() + " has liked," + getStreamObject().getName();
    }


    public void setStreamObject(StreamObject streamObject){
        this.streamObject = streamObject;
    }

    public void setAudience(Person person){
        Person sendTo =getStreamObject().attributesTo;  //the person attributed with the object; 
        getAudience().put(sendTo.preferredUsername, sendTo); //setting the audience to the person attributed with the post; 
    }

}