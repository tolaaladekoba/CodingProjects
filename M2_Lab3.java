/*
Using switch stateement to translate base ten numbers to roman numerals 
Adetola Aladekoba
09/25/2023
 */

import java.util.*;

public class M2_Lab3
{
    public static void main(String[] args)
    {
       Scanner inScan = new Scanner(System.in); 
       String prompt = "This program takes in base ten numbers entered by user "
               + "and changes it to roman numerals\n";
       
              prompt += "\nPlease enter an integer from the range of 1 to"
                      + " 999\n";
              prompt += "If you want to enter 525, simply type in 525 then"
                      + " hit enter\n";
              prompt += "\n --> ";
              
        System.out.print(prompt);
        int number;
        
        if(!inScan.hasNextInt())
            System.out.println("An invalid integer was entered. Please enter"
                    + " an integer from the range of 1 to 999");
        else
        {
            number = inScan.nextInt();
            if(number < 1 || number > 999) 
            System.out.println("\nA value outside of the range was entered");
            
            else
            {
                int unit_Digit = number%10;
                int tens_Digit = number%100/10;
                int hundred_Digit = number/100;

                System.out.println("The isolated digits are:"+" "+hundred_Digit
                        +"  "+tens_Digit+"  " +unit_Digit);

                String romanNumeral = "";

                switch(hundred_Digit)   
                {
                    case 1:
                        romanNumeral += "C";
                        break;
                    case 2:
                        romanNumeral += "CC";
                        break;
                    case 3:
                        romanNumeral += "CCC";
                        break;
                    case 4:
                        romanNumeral += "CD";
                        break;
                    case 5:
                        romanNumeral += "D";
                        break;
                    case 6:
                        romanNumeral += "DC";
                        break;
                    case 7:
                        romanNumeral += "DCC";
                        break;
                    case 8:
                        romanNumeral += "DCCC";
                        break;
                    case 9:
                        romanNumeral += "CM";
                        break;     
                }

                switch(tens_Digit)
                {
                    case 1:
                        romanNumeral += "X";
                        break;
                    case 2:
                        romanNumeral += "XX";
                         break;
                    case 3:
                        romanNumeral += "XXX";
                         break;
                    case 4:
                        romanNumeral += "XL";
                        break;
                    case 5:
                        romanNumeral +="L";
                        break;
                    case 6:
                        romanNumeral += "LX";
                        break;
                    case 7:
                        romanNumeral += "LXX";
                        break;
                    case 8:
                        romanNumeral += "LXXX";
                        break;
                    case 9:
                        romanNumeral += "XC";
                        break;
                }

                switch(unit_Digit)
                {
                    case 1:
                        romanNumeral += "I";
                        break;
                    case 2:
                        romanNumeral += "II";
                        break;
                    case 3:
                        romanNumeral += "III";
                        break;
                    case 4:
                        romanNumeral += "IV";
                        break;
                    case 5:
                        romanNumeral += "V";
                        break;
                    case 6:
                        romanNumeral += "VI";
                        break;
                    case 7:
                        romanNumeral += "VII";
                        break;
                    case 8:
                        romanNumeral += "VIII";
                        break;
                    case 9:
                        romanNumeral += "IX";
                       break;       
                }
                System.out.println("The value of "+number+ " in roman"
                        + " numerals is "+ romanNumeral+"\n");
            }
        }
        System.out.println("Process complete and program terminating ");
    }
}