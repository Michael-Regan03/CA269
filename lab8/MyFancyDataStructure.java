import java.util.*;


class Value implements Comparable<Value>{
    private final Integer value;

    public Integer getValue(){
        return this.value;
    }

    Value(Integer value){
        this.value = value;
    }
    public String toString(){
        return String.valueOf(this.value);
    }   

    static private boolean SORT_LOWER;

    static public void setSortLower(){
        Value.SORT_LOWER = true;
    }

    static public void setSortHigher(){
        Value.SORT_LOWER = false;
    }
    
    static public boolean isSortLower(){
        if(Value.SORT_LOWER){
            return false;
        }else{
            return true;
        }
    }

    static public boolean isSortHigher(){
        if(Value.SORT_LOWER){
            return true;
        }else{
            return false;
        }
    }
    public int compareTo(Value other){
        Integer result = Integer.compare(this.value ,other.value);
        if(isSortLower()){
            if(result == 1){
                return -1;
            }else if(result == -1){
                return 1;
            }
        }
        return result;
    }

}

class PreferHigherValues implements Comparator<Value>{
    public int compare(Value value1, Value value2){
        int result = Integer.compare(value1.getValue(), value2.getValue());
        if(result == 1){
            return -1;
        }else if(result == -1){
            return 1;
        }else{
            return 0;
        }
    }
}

class PreferLowerValues implements Comparator<Value>{
    public int compare(Value value1, Value value2){
        return Integer.compare(value1.getValue(), value2.getValue());
    }
}

class MyFancyDataStructure{
    
}