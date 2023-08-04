class Q1a{
    String title;
    int number;
    int marks;

    Q1a(String title,int number, int marks ){
        title = this.title;
        number = this.number;
        marks = this.marks;
    }

    public String toString(){
        String message = getNumber() +" "+ getTitle() +" (marks:" + getMarks(); 
        return message;
    }

    public String getTitle(){
        return this.title;
    }

    public int getNumber(){
        return this.number;
    }

    public int getMarks(){
        return this.marks;
    }
}