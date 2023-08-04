class NoCakeFoundException extends Exception{
    String message = "The cake is a Lie!";

    NoCakeFoundException(){
    }
    NoCakeFoundException(String message){
    }
    public String toString(){
        return this.message;
    } 
}

class Cake{
    /**
     * getCake always throws a NoCakeFoundException
     */
    public void getCake() throws NoCakeFoundException{
        throw new NoCakeFoundException(); 
    }
    void eatCake() {
        try { 
            getCake();
        }catch(NoCakeFoundException e){ 
            System.out.println(e); 
        }
    }
}