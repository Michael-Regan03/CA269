import java.util.Map;
import java.util.HashMap;
/**
 * @author Michael Regan Student ID: 22112111
 * I hereby declare that this work is all my own according to the DCU plagiarism policy
 * ClientApp is a demonstration of all the components of JavaSoc comping together.
 */
public class ClientApp implements App{
    Map<String,Person> users = new HashMap<String,Person>();
    Person activeUser;


    public Inbox1 getInbox() {
        return this.activeUser.getInbox();
    }

    public Outbox1 getOutbox() {
        return this.activeUser.getOutbox();
    }
    /**
     * for creating new users in ClientApp
     * @param name Name of user
     * @param preferredUsername Username of user
     * @param summary Summary of user
     */
    public void createUser(String name, String preferredUsername, String summary){
        Person person = new Person(name,preferredUsername,summary);
        users.put(person.getPreferredUsername(),person);
        
    }

    /**
     * A demonstration of my work on JavaSoc
     */
    public String demo() {
        
        /*  creating users  */
        System.out.println("mregan25 added");
        createUser("michael","mregan25","computer science student");
        System.out.println("\nok789 added");
        createUser("oliwia","ok789","Interior designer");
        


        this.activeUser =  users.get("mregan25"); //setting active user to mregan25

        Outbox1 outbox_mregan25 = getOutbox();
        Inbox1 inbox_mregan25 = getInbox();
        

        
        /* FollowActivities being sent between users */
        System.out.println("\nregan25 adds a FollowActivity to OutBox");
        FollowActivity follow1 = new FollowActivity(activeUser,  users.get("ok789"));
        Boolean z = outbox_mregan25.send(follow1);
        System.out.println("mregan25 Outbox delivery");
        Activity followactivity1 = outbox_mregan25.deliverNext();
    
        this.activeUser =  users.get("ok789");

        
        Outbox1 outbox_ok789 = getOutbox();
        Inbox1 inbox_ok789 = getInbox();


        System.out.println("ok789 Inbox delivery");
        Activity followactivity2 = inbox_ok789.readNext();

        System.out.println("ok789 reads a FollowActivity from Inbox");
        inbox_ok789.response(followactivity2);

        System.out.println("ok789 adds a FollowActivity to OutBox");
        FollowActivity follow2 = new FollowActivity(activeUser,  users.get("mregan25"));
        Boolean k = outbox_ok789.send(follow2);
        
        System.out.println("ok789 Outbox delivery");
        Activity followactivity3 = outbox_ok789.deliverNext();

        this.activeUser =  users.get("mregan25");

        System.out.println("mregan25 Inbox delivery");
        Activity followactivity4 = inbox_mregan25.readNext();
        
        System.out.println("mregan25 reads a FollowActivity from Inbox");
        inbox_ok789.response(followactivity4);


        /* CreateActivity being sent */
        System.out.println("mregan25 adds a CreateActivity to OutBox");
        CreateActivity post1 = new CreateActivity(activeUser, "my first post", "I love JavaSoc");
        Boolean x = outbox_mregan25.send(post1);
        
        System.out.println("mregan25 Outbox delivery");
        Activity createactivity1 = outbox_mregan25.deliverNext();

        this.activeUser =  users.get("ok789");

        System.out.println("ok789 Inbox delivery");
        Activity createactivity2 = inbox_ok789.readNext();

        System.out.println("ok789 reads a CreateActivity from Inbox");
        inbox_ok789.response(createactivity2);

        /* LikeActivity being sent */
        System.out.println("ok789 adds a LikeActivity to OutBox");
        LikeActivity likeactivity1 = new LikeActivity(activeUser, createactivity2);
        boolean y = outbox_ok789.send(likeactivity1);
        System.out.println("ok789 OutBox delivery"); 
        Activity likeactivity2 = outbox_ok789.deliverNext();


        this.activeUser =  users.get("mregan25");

        System.out.println("mregan25 Inbox delivery");   
        Activity likeactivity3 = inbox_mregan25.readNext();

        System.out.println("mregan25 reads a LikeActivity from Inbox");
        inbox_mregan25.response(likeactivity3);

        /* DeleteActivity being sent */
        System.out.println("mregan25 adds a DeleteActivity to OutBox");
        DeleteActivity delete1 = new DeleteActivity(activeUser, createactivity1 );
        Boolean o = outbox_mregan25.send(delete1);
        System.out.println("mregan25 Outbox delivery");
        Activity delete2 = outbox_mregan25.deliverNext();


        this.activeUser =  users.get("ok789");

        System.out.println("ok789 Inbox delivery");
        Activity delete3 = inbox_ok789.readNext();

        System.out.println("ok789 reads a DeleteActivity from Inbox");
        inbox_ok789.response(delete3);


        this.activeUser =  users.get("mregan25");

         /* UnfollowActivity being sent */
        System.out.println("mregan25 adds a UnfollowActivity to OutBox");
        FollowActivity unfollow1 = new UnfollowActivity(activeUser,  users.get("ok789"));
        Boolean e = outbox_mregan25.send(unfollow1);
        System.out.println("mregan25 Outbox delivery");
        Activity unfollowactivity1 = outbox_mregan25.deliverNext();

        this.activeUser =  users.get("ok789");

        System.out.println("ok789 Inbox delivery");
        Activity unfollow3 = inbox_ok789.readNext();

        System.out.println("ok789 reads a UnfollowActivity from Inbox");
        inbox_ok789.response(unfollow3);



        return "";
    }

    

}