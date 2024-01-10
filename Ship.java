/*
 Creating a class ship  
 Adetola Aladekoba
 11/24/2023
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Ship 
{
    
    private String name;
    private int year;
    private String country;
    
    public Ship(String name,int year, String country)
    {
        this.name = name;
        this.year = year;
        this.country = country;
    } 
    
    public String toString()
    {
        return getName() + "," + getYear() + "," + "flag:" + getCountry();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }
    
    public static void main(String[] args)
    {
        ArrayList<Ship> ships = new ArrayList<>();
        String fileName = "justShips.csv";
        File inFile = new File(fileName);
          
        try 
        {   
            Scanner inScan = new Scanner(inFile);
            while(inScan.hasNextLine())
            {
               String shipLine = inScan.nextLine();
               String []roster = shipLine.split(",");
               String name = roster[0];
               int year = Integer.parseInt(roster[1]);
               String country = roster[2];
               Ship ship = new Ship(name, year, country);
               ships.add(ship);
                
            }
               inScan.close();
        }
        catch(IOException ioe)
           {
               String errorMessage = "Trouble reading file:" +fileName;
               JOptionPane.showMessageDialog(null, 
                           errorMessage, "File error",
                           JOptionPane.ERROR_MESSAGE);
               System.exit(0);
           }
              String shipRoster = "Our Fleet:\n";
              for(Ship ship: ships)
              {
                  shipRoster += ship.toString()+"\n";
              }
              String welcomeMessage= "This program is to assemble a roster of"
                      + " ships.\n"+"To see the roster just click on \"OK\" and"
                      + " "+ "the roster will be displayed";
              JOptionPane.showMessageDialog(null,
                      welcomeMessage,"Welcome Message  "
                              + " Adetola Aladekoba", 
                      JOptionPane.INFORMATION_MESSAGE);
              JOptionPane.showMessageDialog(null,
                      shipRoster,"Fleet Roster     Adetola Aladekoba"
                      ,JOptionPane.INFORMATION_MESSAGE);
             
              String terminationMessage = "Process complete and program"
                      + " terminating";
              JOptionPane.showMessageDialog(null,
                      terminationMessage, "Termination Screen  "
                              + " Adetola Aladekoba", 
                      JOptionPane.INFORMATION_MESSAGE);
}
    }  

