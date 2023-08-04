class Individual{
    /**
     * public field called name for storing names, e.g. "Harshvardhan"
     */
    String name;

    /**
     *  constructor that takes and sets one parameter for name.
     * @param name Name of person
     */
    Individual(String name){
        this.name = name;
    }
    
    /**
     * method that returns the name.
     */
    public String toString(){
        return name;
    }

}

/**
 *  subclass of Individual
 */
class Person extends Individual{
    /**
     *  a protected field called "nickname" for storing nicknames, e.g. "Harsh"
     */ 
    private String nickname;

    /**
     * constructor that takes two parameters, first for name, and another for nickname
     * @param name Name of Individual
     * @param nickname Nickname of Person
     */
    Person(String name, String nickname){
        super(name);
        this.nickname = nickname;

    }

    public String toString(){
        return this.name + " (" + this.nickname + ")";
    }
}