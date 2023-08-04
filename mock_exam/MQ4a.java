class Factory<T>{
    public T item;
    public T getItem() { 
        return this.item; 
    }
    public void setItem(T t){
        this.item = t;
    }
}

class Apple { }
class Orange { }
class Lemon { }

class AppleFactory extends Factory{
    public Apple item;
}

class OrangeFactory extends Factory{
}

class LemonFactory extends Factory<Lemon> {
    @Override
    public void setItem(Lemon item) {
        if(this.item == null){ 
            this.item = item; 
        }
    }
    public void removeItem(){ 
        this.item = null; 
    }
}