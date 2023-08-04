class Person implements VIP{
    private String name;
    public String VIP;

    Person(String name, String VIP){
        this.name = name;
        this.VIP = VIP;
    }

    public String VIPStatus(){
        return this.VIP;
    }
}

class Employee extends Person {
    private String empoyeeID;

    Employee(String name, String VIP, String employeeID){
        super(name,VIP);
        this.empoyeeID = employeeID;
    }
}

interface VIP {
    String VIPStatus();
}

class CompanyGathering{
    CompanyGathering(){

    }
    boolean admitPerson(Person person){
        if(person.VIPStatus()=="Yes"){
            return true;
        }else if(person instanceof Employee){
            return true;
        }else{
            return false;
        }
    }
}