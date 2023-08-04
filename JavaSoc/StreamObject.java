import java.util.Map;
import java.util.HashMap;
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * streamObjects are the posts that are made on JavaSoc
 */
public class StreamObject {
    String URI;
    Person attributesTo;
    Map<String,Person> likes = new HashMap<String,Person>();
    Map<String,Person> shares = new HashMap<String,Person>();
    String content;
    String name;
    //Boolean published;
    Boolean deleted = false;

    public static int instances = 0;

    /**
     * Constructs a StreamObject object with the given person, content, and name parameters.
     * @param person The person is attributed to the stream object.
     * @param content The content of the stream object.
     * @param name The name of the stream object.
    */
    StreamObject(Person person, String content, String name){
        instances += 1;
        setAttributedTo(person);
        setContent(content);
        setName(name);
    }

    /**
     * Adds a person to the likes map.
     *  @param person A person sent a LikeActivity in relation to this stream object .
    */
    public void addLike(Person person){
        likes.put(person.getPreferredUsername(),person);
    }
    /**
     * Removes a person from the likes map.
     * @param person The person being removed from the map.
     */
    public void removeLike(Person person){
        likes.remove(person.getPreferredUsername());
    }
   

    /**
     * @param person Person attributed to the stream object
     */
    public void setAttributedTo(Person person){
        this.attributesTo = person;
    }

    /**
     * @return person Person attributed to the stream object.
     */
    public Person getAttributedTo(){
        return this.attributesTo;
    }

    /**
     * @return content The content of the stream object.
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * @return The content of the stream object.
     */
    public String getContent(){
        return this.content;
    }
    
    /**
     * @param name The name of the stream object
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 
     * @return The name of the stream object.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * @return The URI of the stream object which will include the username of the person attributed to the stream object and the nth time the class has been called
     */
    public String getURI(){
        String URI = "https://JavaSoc.com/" + this.getAttributedTo().preferredUsername + "/streamObject" + instances;
        return URI;
    }

    /**
     * @return A map of all the people who liked the stream object.
    */
    public Map<String,Person> getLikes(){
        return this.likes;
    }

    /**
     * @return a string of all the peoples's usernames who like the stream object.
     */
    public String showLikes(){
        if(getLikes().isEmpty()){
            return "null";
        }
        String output = "";
        for(String likes: getLikes().keySet()) {
            output += likes + " ";
        }
        return output;
    }

    /**
     * Setting delete to true.
     */
    public void delete(){
        this.deleted = true;
    }

    /**
     * @return The deleted status of the stream object.
     */
    public boolean getDeletedStatus(){
        return this.deleted;
    }
}