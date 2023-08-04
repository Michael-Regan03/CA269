package lab1;
import java.util.Scanner;

public class VowelAge {
    
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        String name = input.nextLine();
        int age = input.nextInt();
    
        String vowel = "AaOoIiEeUu";
        
        char[] vowels = vowel.toCharArray();
    
        char[] new_name = name.toCharArray();
        
        int num_of_vowels = 0;

        for(int i=0; i<new_name.length; ++i){
            for(int j =0; j<vowels.length; ++j){
                if(new_name[i] == vowels[j]){
                    ++num_of_vowels;
                    break;
                }
            }
        }
        System.out.printf("Hello %s, you have %d vowels", name, num_of_vowels);

        if( age > 17){
            System.out.printf(", and you are an adult\n");
        }else{
            System.out.printf(", and you are a minor\n");
        }
    }

}
