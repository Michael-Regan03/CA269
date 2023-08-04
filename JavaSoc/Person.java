import java.util.Map;
import java.util.HashMap;
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * The Person instances are the users of JavaSoc and can send Activities to one another
 */

public class Person{
    String name;
    String preferredUsername;
    String summary;
    Inbox1 inbox = new Inbox1();
    Outbox1 outbox = new Outbox1();
    Map<String,Person> followers = new HashMap<String,Person>();
    Map<String,Person> following = new HashMap<String,Person>();
    Map<String,StreamObject> liked = new HashMap<String,StreamObject>();
    
    /**
     * Constructor for creating a new Person object with only a preferred username.
     * @param preferredUsername the preferred username for the person.
    */
    Person(String preferredUsername){
        setPreferredUsername(preferredUsername);
      
        System.out.println("- URI: " + getURI() + "\n - username: "+ getPreferredUsername());

    }
    /**
     * Constructor for creating a new Person object with a name, preferred username, and summary.
     * @param name the name of the person.
     * @param preferredUsername the preferred username of the person.
     * @param summary the summary of the person.
    */
    Person(String name, String preferredUsername, String summary){
        setPreferredUsername(preferredUsername);
        setName(name);
        setSummary(summary);
        System.out.println("- URI: " + getURI() + "\n- username: "+ getPreferredUsername() + "\n- name: " + getName() + "\n- summary: " + getSummary() );
    }


    public void setPreferredUsername(String preferredUsername){
        this.preferredUsername = preferredUsername;
    }
    
    public String getPreferredUsername(){
        return this.preferredUsername;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    public void setSummary(String summary){
        this.summary = summary;
    }
    
    public String getSummary(){
        return summary;
    }


    public void addFollowers(Person person){
        String username = person.getPreferredUsername();
        this.followers.put(username, person);
    }

    public void addFollowing(Person person){
        String username = person.getPreferredUsername();
        this.following.put(username, person);
    }

    public void removeFollowers(Person person ){
        this.followers.remove(person.getPreferredUsername());
    }

    public void removeFollowing(Person person ){
        this.following.remove(person.getPreferredUsername());
    }


    public Map<String,Person> getFollowers(){
        return this.followers;
    }

    public Inbox1 getInbox(){
        return this.inbox;
    }

    public Outbox1 getOutbox(){
        return this.outbox;
    }
     /**
     * @return The URI of the person which will include the username of the person
     */
    public String getURI(){
        String URI = "https://JavaSoc.com/" + getPreferredUsername() ;
        return URI;
    }

}