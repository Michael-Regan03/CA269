class Reflection{
    public static boolean checkField(Class<?> c, String field){
        if (c == null) {
            return false;
        }
        try {
            c.getDeclaredField(field);
            return true;
        } catch (NoSuchFieldException e) {
            Class<?> superClass = c.getSuperclass();
            if (superClass != null) {
                return checkField(superClass, field);
            }
            return false;
        }
    }


    public static boolean checkMethod(Class<?> c, String method){
        if (c == null) {
            return false;
        }
        try {
            c.getDeclaredMethod(method);
            return true;
        }catch (NoSuchMethodException e) {
            Class<?> superClass = c.getSuperclass();
            if (superClass != null) {
                return checkField(superClass, method);
            }
            return false;
        }
    }
    public static boolean isClass(Class<?> c){
        if(c.isInterface()){
            return false;
        }else{
            return true;
        }
            
    }

    public static boolean isInterface(Class<?> c){
        return c.isInterface();
            
    }
    
    
    public static boolean hasAncestor(Class<?> c, String ancestor) {   
        if (c == null) {
            return false;
        }
    
        if (c.getSuperclass() != null && c.getSuperclass().getName().equals(ancestor)) {
            return true;
        }


        for (Class<?> i : c.getInterfaces()) {
            if (i.getName().equals(ancestor)) {
                return true;
            }
        }
        

        if (c.getSuperclass() != null && hasAncestor(c.getSuperclass(), ancestor)) {
            return true;
        }
        for (Class<?> i : c.getInterfaces()) {
            if (hasAncestor(i, ancestor)) {
                return true;
            }
        }
    
        // No ancestor found
        return false;
    }


    public String WishYouA(){
        return "Happy St. Patrick's Day!";
    }
}

class A {
    public String f_A;
}

class B extends A { }

interface X {
    void m_X();
}

class C extends B implements X {
    private String f_C;
    public void m_X() { }
}