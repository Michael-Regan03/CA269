
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * CreateActivity is the action of creating a streamObject.
 */
public class CreateActivity extends BasicActivity{
    Person person;
    /**
     * A constructor for the CreateActivity object.
     * @param person Person creating the streamObject.
     * @param name The Name of the streamObject.
     * @param content The Content of the streamObject.
     */
    CreateActivity(Person person, String name, String content){
        super(person);
        setStreamObject(person,name,content);
        setAudienceToFollowing(person);
        setSummary();
    }

    public void setStreamObject(Person person, String content, String name){
        this.streamObject = new StreamObject(person,content,name);
    }


    public void setAudienceToFollowing(Person person){
        setAudience(person.getFollowers());    
    }

    void setSummary(){
        this.summary = getPerson().getPreferredUsername() + " has just posted, " + this.streamObject.getName()+ ", " + this.streamObject.getContent(); 
    }

    public String getSummary(){
        return this.summary;
    }
    

      /**
     * @return A String representation of the UnfollowActivity object.
     */   
    public String toString(){
        return "-URI: " + getURI() + "\n-Audience: followers\n-Likes: " + getStreamObject().showLikes() + "\n-content: " + getStreamObject().getContent() + "\n-name: " + getStreamObject().getName() + "\n-deleted: " + getStreamObject().getDeletedStatus() + "\n";
    }

}