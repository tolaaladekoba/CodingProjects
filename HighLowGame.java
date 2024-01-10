/*
 * Adetola Aladekoba
 * Dice game for user to guess if their dice throw total is lower or higher 
   than the total of the dice throw total of the program
 * 09/14/2023
 */

import java.util.*;

public class HighLowGame {
    
    public static void main(String[] args) 
    { 
         Scanner keyboardScanner = new Scanner(System.in);
         
         String user_prompt = """
                            This program is a dice game that will be played
                            between a player and a computer.
                            
                            The player's total dice throws will be summed
                            and the player will have to guess if their total 
                            dice throws will be higher or lower than the 
                            computer's total dice throws, and if they guess
                            correctly,they win
                              """;
         System.out.println(user_prompt);
         
         Random randGen = new Random();
         String user_die ="\nYou rolled the following values:";
         System.out.println(user_die);
         int user_die_1 = (randGen.nextInt(6))+1;
         int user_die_2 = (randGen.nextInt(6))+1;
         int user_die_3 = (randGen.nextInt(6))+1;
         int user_die_4 = (randGen.nextInt(6))+1;
         int user_die_5 = (randGen.nextInt(6))+1;
        
         System.out.println("die 1 --> "+(user_die_1));
         System.out.println("die 2 --> "+(user_die_2));
         System.out.println("die 3 --> "+(user_die_3));
         System.out.println("die 4 --> "+(user_die_4));
         System.out.println("die 5 --> "+(user_die_5));
         int user_total= user_die_1+user_die_2+user_die_3+user_die_4+user_die_5;
         String end_user_prompt = "Which totals to "+user_total;
         System.out.println(end_user_prompt);
     
         user_prompt ="\nPlease enter H if you think your roll will be higher\n"
                      +"         or L if you think your roll will be lower\n\n"; 
         user_prompt += "--> ";
         System.out.print(user_prompt);
         String user_guess = keyboardScanner.next().toUpperCase();
         
         String prompt = "\nThe computer rolled the following values:";
         System.out.println(prompt);
         
         int computer_die_1 = (randGen.nextInt(6))+1;
         int computer_die_2 = (randGen.nextInt(6))+1;
         int computer_die_3 = (randGen.nextInt(6))+1;
         int computer_die_4 = (randGen.nextInt(6))+1;
         int computer_die_5 = (randGen.nextInt(6))+1;
       
         System.out.println("die 1 --> "+ computer_die_1);
         System.out.println("die 2 --> "+ computer_die_2);
         System.out.println("die 3 --> "+ computer_die_3);
         System.out.println("die 4 --> "+ computer_die_4);
         System.out.println("die 5 --> "+ computer_die_5);
         
         int computer_die_total = computer_die_1+computer_die_2+computer_die_3+
                 computer_die_4+computer_die_5;
       
         String end_prompt ="Which totals to " + computer_die_total;
         System.out.println(end_prompt);
         
        if(user_total>computer_die_total && user_guess.equals("H"))
        {
            System.out.println("\nYou called \"higher\" correctly and scored "
                    + "plus one point"); 
        }
        else if (user_total<computer_die_total && user_guess.equals("L"))
        {
            System.out.println("\nYou called \"lower\" correctly and scored"
                    + " plus one point");
        }
        else
        {
            System.out.println("\nYou lose");
        }
        System.out.println("Process complete and program ending!");
             }   
        
}
