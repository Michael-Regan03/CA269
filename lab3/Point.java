public class Point implements Comparable{
    public double x, y;

    public Point(double newX, double newY) { 
        x = newX;
        y = newY;
    }


    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean lessThan(Order other) {
    if(other instanceof Point){ 
        Point otherPoint = (Point) other;
        if( equals(this.x, otherPoint.x) ){
            if(this.y < otherPoint.y){
                return true;
            }else{
                return false;
            }
        }if(this.x < otherPoint.x){
            return true;
        }else {
            return false;
        }
    }else{
        return false;
    }
    }

    public boolean equals(double x, double y){
        if(x == y){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public int compareTo(Object other) {
        if(other instanceof Point){ 
            Point otherPoint = (Point) other;
            if( this.x+this.y == otherPoint.x+otherPoint.y ){
                return 0;
            }else if(this.x+this.y < otherPoint.x+otherPoint.y){
                return -1;
            }else {
                return 1;
            }
        }else{
            return 0;
        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}