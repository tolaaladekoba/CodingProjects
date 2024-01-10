/*
 Working with arrays and custom methods 
 Adetola Aladekoba
 11/07/2023
 */

import java.util.*;

public class ArrayComparison {
    
    public static void main(String[] args) 
    {
        int highLimit = 130;
        int lowLimit = 110;
        int elements = 25;
        
        int[] secondArray = initializeArray(highLimit, 
                lowLimit,elements);
        int[] firstArray = initializeArray( highLimit,
                lowLimit,elements);
        
        System.out.println("This program generates two sets of random numbers "
                + "of the same length, \ncalculates the total number of values "
                + "in the first set that are greater than the numbers in the "
                + "second set of every index value,\ncalculates the total "
                + "number of values in the second set that are greater than"
                + " the numbers in the first set of every index value,\nand "
                + "calculates the total number of ties between each index of "
                + "the two random sets of numbers.\n");
        printTwoArrays(firstArray,secondArray);
        compareArrays(firstArray,secondArray);    
    }
    
    public static void printTwoArrays(int []arrayOne, int[]arrayTwo)
    {
        for(int dex= 0; dex<arrayOne.length ; dex++)
        {
           String dex_str1 = String.format("index %2d:",dex);
           String dex_str2 = String.format("%3d %3d",arrayOne[dex],
                   arrayTwo[dex]);
           System.out.println(dex_str1+ " "+ dex_str2);
        }
    }
    
    public static int[] initializeArray (int upperLimit, int lowerLimit,
            int num_elements)
    {
        int[] arrayOfInts = new int[num_elements];
        Random randGen = new Random();
        int numberValues = upperLimit - lowerLimit+1;
        for(int dex = 0; dex< num_elements; dex++)
        {
            arrayOfInts[dex]= randGen.nextInt(numberValues) + lowerLimit;   
        }
        return arrayOfInts;
    }
    
    public static void compareArrays (int [] arrayOneCompare, int [] 
            arrayTwoCompare)
    {
       int arrayOneHigh = 0;
       int arrayTwoHigh = 0;
       int arrayTies = 0;
       
        for(int dex= 0; dex<arrayOneCompare.length ; dex++)
        {
           if(arrayOneCompare[dex]==arrayTwoCompare[dex])
               arrayTies +=1;
           else if(arrayOneCompare[dex]>arrayTwoCompare[dex])
               arrayOneHigh += 1;
           else
               arrayTwoHigh += 1;  
        }
        
        String arrayResults ="\narray 1 has "+ arrayOneHigh+" highs\n" ;
              arrayResults += "array 2 has "+ arrayTwoHigh+" highs\n";
              arrayResults += "There are "+ arrayTies+" ties";
              
        System.out.println(arrayResults);
        System.out.println("\nProcess complete and program ending");          
    }
}
       

