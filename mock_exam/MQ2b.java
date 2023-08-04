interface FamilyMember extends PersonalDetails {
    String getNickname();
    void setNickname(String name);
}

interface PersonalDetails {
    String getName();
    int getAge();
}

class Individual implements PersonalDetails{
    String name;
    int Age;

    Individual(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.Age;
    }

}

class Person extends Individual implements FamilyMember{
    private String nickname;

    Person(String name, String nickname){
        super(name);
        this.nickname = nickname;

    }

    public String toString(){
        return this.name + " (" + this.nickname + ")";
    }

    public String getNickname(){
        return this.nickname;
    }

    public void setNickname(String name){
        this.nickname = name;
    } 
}