import java.util.Map;
import java.util.HashMap;
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 *BasicActivity implements Activity and is the most basic activity that extends all other Activity classes.
 */
public class BasicActivity implements Activity {
    String URI;
    Person person;
    String summary;
    Map<String,Person> audience = new HashMap<String,Person>();
    StreamObject streamObject;

    public static int instances = 0;
    /**
     * Constructor for BasicActivity Object
     * Increments instances to keep track of how many instances are being created
     * @param person Person preforming the Activity
     */
    BasicActivity(Person person){
        instances += 1;
        setPerson(person);
        this.URI = getURI();

    }

    public Person getPerson(){
        return this.person;
    }
    
    void setPerson(Person person){
        this.person = person;
    }

    public String getURI(){
        String URI = "https://JavaSoc.com/" + getPerson().preferredUsername + "/activity" + instances;
        return URI;
    }

    public Map<String,Person> getAudience(){
        return this.audience;
    }

    public void setAudience(Map<String,Person> audience){
        this.audience = audience;
    }

    String getSummary(){
        return this.summary;
    }

    public StreamObject getStreamObject(){
        return this.streamObject;
    }


}