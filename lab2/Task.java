import java.time.LocalDate;
import java.time.Period;

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}

class Task{
    // think why private is the WRONG choice here
    // instead, think what should be the access modifier
    
    private final String title;
    private String description;
    private LocalDate scheduled;
    private LocalDate deadline; // think why this isn't final
    public State state;

    //constructors
    public Task(String title, State state) {
        this.title = title;
        this.state = state;
    }

    public Task(String title, String description, LocalDate scheduled, LocalDate deadline, State state) {
        this(title, state);
        this.description = description;
        this.scheduled = scheduled;
        this.deadline = deadline;
    }

    //setters and getters
    public String getTitle() {
        return title;
    }

    public String toString() {
        String message = this.title + " (" + this.state + ")";
        if (scheduled != null) {
            message += " scheduled: " + scheduled;
        }
        if (deadline != null) {
            message += " deadline: " + deadline;
        }
        return message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getScheduled() {
        return scheduled;
    }

    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public State getState() {
        return state;
    }

    public void setState(State state){
        this.state = state;
    }


}

class Chore extends Task {
    // think how to use inheritance to avoid repeating fields from Task
    public LocalDate repeat;

    public Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {       // parameters are the mandatory fields: we need scheduled
        // super() is to ensure parent constructor is called - otherwise we get Errors!
        super(title, state);

        // even in constructor, defer to setters
        // because there may be input validation, default values, etc. implemented in them
        setScheduled(scheduled);
        setRepeat(repeat);
        setState(state);
    }


    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }
    
    public void setState(State state) {
        //if state is DONE:
        // setState(state) using super.setState() is an option
        // OR copy the code again in this method
        if (state == State.DONE) {
            LocalDate repeat_new = repeat.plus(Period.ofDays(7)); //first set repeat to +7 days
            setScheduled(this.repeat); // scheduled = repeat
            setRepeat(repeat_new);
            this.state = State.TODO;
        }
        else{
            this.state = state;
        }
    }
    public String toString() {
        String message = getTitle() + " (" + getState() + ") scheduled: " + getScheduled();
        return message;
    }
}


class RepeatedTask extends Task {
    
    LocalDate repeat;

    public RepeatedTask(String title, State state) {
        // parameters are the mandatory fields
        // super() is to ensure parent constructor is called - otherwise we get Errors!
        super(title, state);
        // even in constructor, defer to setters
        // because there may be input validation, default values, etc. implemented in them
        setRepeat(repeat);
    }

    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }

    
    public void setState(State state) {
        //if state is DONE:
        // setState(state) using super.setState() is an option
        // OR copy the code again in this method
        if (state == State.DONE) {
            setState(State.TODO);     //et state back to Done, This is the difference between chore and repeated
        }else{
            this.state = state;
        }
    }

}

class SharedTask extends Task{

    private String name;

    public SharedTask(String title, String name){
        super(title, State.WAIT);
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public String toString() {
        String message = getTitle() + " (" + getState() + ") shared with: " + getName();
        return message;
    }
}

class Dependency extends Task{

    private Task task;

    Dependency(String title, State state, Task task){
        super(title, state);
        setTask(task);
    }


    public void setTask(Task task) {
        this.task = task;
    }
    
    public void setState(State state){
        //if state is DONE:
        // setState(state) using super.setState() is an option
        // OR copy the code again in this method
        if (this.task.getState() == State.DONE){
                this.state = state;
            
        }
    }
    
    public String toString() {
        String message = getTitle() + " (" + getState() + ") dependent on: " + task.getTitle() + " (" + task.getState() + ")" ;
        return message;
    }

}