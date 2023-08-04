package lab1;
import java.util.Scanner;

public class AlarmClock {
    
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        
        int alarm1 = input.nextInt();
        int alarm2 = input.nextInt();
        
        int alarm = ((alarm1*100) + alarm2);

        int hours =  input.nextInt();
        int minutes = input.nextInt();

        int time = ((hours*100) + minutes);

        int output = 0;

        while(time < alarm){
            ++output;
            hours =  input.nextInt();
            minutes = input.nextInt();
            time = ((hours*100) + minutes);

        }
        System.out.printf("false alarms: %d\n", output);
    }
}