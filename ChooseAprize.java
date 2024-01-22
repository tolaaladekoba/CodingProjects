/*
 * First lab: review of Random class, Input through JOptionPanes,
    Icon images, and program loop
 * Adetola Aladekoba
 * 01/18/2024
 */

import java.util.*;
import javax.swing.*;
import java.io.*;

public class ChooseAprize{
    
    public static void main(String[] args)
    {
        String[] islands = {"Bermuda", "Bahama", "Jamaica", "Aruba",
                "Martinique", "Antigua"};
        String[] activities = {"parasailing", "surfing", "snorkeling",
                "DeepSeaFishing", "sailBoarding", "sharkSpotting",
                "JetSkiing", "scubaing", "shipwreck"};
        
        Random randGen = new Random();
        
        String[] options = {"Get Another trip!", "Quit"};

        ImageIcon welcomeIcon = new ImageIcon("icons/prize.png");
        String welcomeMessage = "This program will randomly generate a grand "
                + "prize\nthat includes a trip to a Caribbean Island and a "
                + "two-day\npass for a specific island-related activity.\n "
                + "\nClick on 'Ok' to see your prize!!";
        JOptionPane.showMessageDialog(null, welcomeMessage,
                "Welcome to the Prize chooser, hosted by Adetola Aladekoba"
                ,0,welcomeIcon);

        int choice = 0;
        while (choice == 0)
        {
            int islandIndex = randGen.nextInt(islands.length);
            int activityIndex = randGen.nextInt(activities.length);

            String activityFile = "icons/" + activities[activityIndex] + ".png";
            File iconFile = new File(activityFile);

            ImageIcon prizeIcon = new ImageIcon(activityFile);
            String prizeText = "<html><h1> in " + islands[islandIndex] + "</h1>"
                    ;

            String prizeMessage = "Your prize presented by Adetola Aladekoba";
            choice = JOptionPane.showOptionDialog(null, 
                    prizeText,prizeMessage, 0, 1,
                    prizeIcon, options, options[0]);
        }
        
        String terminationMessage = "Enjoy your prize!\nProgram ending";
        ImageIcon terminationIcon = new ImageIcon("icons/Trip.png");
        JOptionPane.showMessageDialog(null,
                terminationMessage, "Thank you for playing!   "
                        + " Adetola Aladekoba", 0, terminationIcon)
                ;
    }
}
