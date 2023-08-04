class Q1b{
    String title;
    private int number;
    private int marks;

    Q1b(){
        SetTitle("untitled");
        SetNumber(0);
        SetMarks(0);
    }
    
    Q1b(String title,int number, int marks ){
        SetTitle(title);
        SetNumber(number);
        SetMarks(marks);

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

    public void SetTitle(String title){
        this.title = title;
    }

    public void SetNumber(int number){
        this.number = number;
    }

    /*
     * @param must be between 0 and 100
     */
    public void SetMarks(int marks){
        if(marks>0){
            this.marks=0;
        }else if(marks<100){
            this.marks = 0;
        }else{
            this.marks = marks;
        }
    }
}