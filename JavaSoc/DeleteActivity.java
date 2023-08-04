
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * DeleteActivity extends BasicActivity is a delete action whereby a person sets a streamObject's deleted boolean to true. Making it unable to be seen by other people after passing it to the method response() in their inbox. 
 */
class DeleteActivity extends BasicActivity {
    Person person;
    /**
     * A constructor for a DeleteActivity object.
     * @param person Person who is deleting a streamObject.
     * @param activity Activity containing the streamObject being deleted.
     */
    DeleteActivity(Person person, Activity activity){
        super(person);
        setStreamObject(activity.getStreamObject());
        setAudienceToFollowing(person);
        delete();
    }

    public void setStreamObject(StreamObject streamObject){
        this.streamObject = streamObject;
    }


    public void setAudienceToFollowing(Person person){
        setAudience(person.getFollowers());    
    }

    public String getSummary(){
        return this.summary;
    }
    
    public void delete(){
        getStreamObject().delete();
    }

    /**
     * @return A String representation of the DeleteActivity object.
     */
    public String toString(){
        return "-URI: " + getURI() + "\n-Audience: followers\n-Likes: " + getStreamObject().showLikes() + "\n-content: " + getStreamObject().getContent() + "\n-name: " + getStreamObject().getName() + "\n-deleted: " + getStreamObject().getDeletedStatus() + "\n";
    }

}
