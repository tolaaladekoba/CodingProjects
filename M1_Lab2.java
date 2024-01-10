/*
Practice working with SCANNERS and RANDOM and Constants
Adetola Aladekoba
09/04/2023
 */

import java.util.*;

public class M1_Lab2 {
    
    public static void main(String[] args) 
    {
        Scanner keyboardScanner = new Scanner(System.in);
        String prompt = "\nPlease enter the lower range as an integer "
                + "in the range of -10 to 10\n";
               prompt += "If you want to enter -9, simply type in -9 and "
                       + "hit enter";
               prompt +="\n --> ";
              
        System.out.print(prompt);
        int lower_number = keyboardScanner.nextInt();
        
        
        
        prompt  = "\nPlease enter the higher range as an integer in the range"
                + " of -10 to 10\n";   
        prompt += "If you want to enter 9, simply type in 9 and hit enter";
        prompt +="\n --> "; 
        
        System.out.print(prompt);
        int higher_number = keyboardScanner.nextInt();
        int number_of_values= (higher_number - lower_number )+ 1;     
        Random randGen = new Random();  
        
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));
        System.out.println("Random number:" +
                (randGen.nextInt(number_of_values)+lower_number));

        
        



        
 
        
        
    }
    
}
