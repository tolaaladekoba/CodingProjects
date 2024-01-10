/*
  Entering data and communicating with the JOptionPanes
  Adetola Aladekoba
  07/17/2023
 */


import java.util.*;
import javax.swing.*;

public class Lab4_RPS {
    
    public static void main(String[] args)
    {
        ImageIcon icon = new ImageIcon("RPS.png");
        String welcome_message= "This program will allow you to play Rock Paper"
                + " Scissors against the computer.\n"+ "You will be allowed to "
                + "play three rounds.\n" +"Your wins, losses, and ties will be "
                + "shown at the end of the three rounds.";
        JOptionPane.showMessageDialog(null,  welcome_message, 
                "Welcome Message                       Adetola Aladekoba", 
                0, icon);
        
        int wins = 0;
        int losses = 0;
        int ties = 0;
        int counter = 0;

        while ( counter < 3)
        { 
            String prompt = "Please, click on one of\n"+
                            "the following buttons,\n"+
                            "corresponding to your play\n";
            String[] choices = {"Scissors","Paper","Rock"};

            int choice = JOptionPane.showOptionDialog(null,
                    prompt,"Play \"Rock, Paper, Scissors\"   "
                            + "  Adetola Aladekoba",0, 0, 
                            icon, choices, choices[0]);

            String player_choice= "";
            String computer_choice= "";
        
            switch(choice)
            {
                case 2:
                    player_choice += "Rock";
                    break;
                case 1:
                     player_choice += "Paper";
                     break;
                case 0:
                     player_choice += "Scissors";
                     break;
            }

            Random rand = new Random();
            int computer_random = rand.nextInt(3);

            switch( computer_random)
            {
                case 0:
                    computer_choice += "Scissors";
                    break;
                case 1:
                    computer_choice += "Paper";
                    break;
                case 2:
                    computer_choice += "Rock";
                    break;      
            }

            String resultsAccumulator = "<html> You played "+ player_choice+ 
                    " and<br> " +" The computer played "
                    + computer_choice +"<br>";  

            ImageIcon resultIcon ;
            if(computer_choice.equals(player_choice))
            {
                resultsAccumulator += "<h2><br>It's a tie!</h2>" ;
                resultIcon = new ImageIcon("RPS2.png");
                ties += 1;
            }
            else if(computer_choice.equals("Rock")&& player_choice.equals
            ("Paper"))
            {
                resultsAccumulator +="<h2><br>Paper wraps rock</h2><br><br>" 
                        +" You win!";
                resultIcon = new ImageIcon("paperWrapsRock.png");
                wins += 1;
            }
            else if(computer_choice.equals("Paper")
                    && player_choice.equals
            ("Rock"))
            {    
                resultsAccumulator += "<h2><br>Paper wraps rock</h2><br><br>"+
                        " You lose!";
                resultIcon = new ImageIcon("paperWrapsRock.png");
                losses += 1;
            }
            else if(computer_choice.equals("Rock")&& player_choice.equals
            ("Scissors"))
            {
                resultsAccumulator += "<h2><br>Rock crushes scissors</h2>"
                        + "<br><br>" +" You lose!";
                resultIcon = new ImageIcon("rockCrushScissor.png");
                losses += 1;
            }
            else if (computer_choice.equals("Paper")&&
                    player_choice.equals
            ("Scissors"))
            {
                resultsAccumulator += "<h2><br>Scissors cuts paper </h2>"
                        + "<br><br>"+ " You win!";
                resultIcon = new ImageIcon("scissorCutPaper.png");
                wins += 1;
            }
            else if(computer_choice.equals("Scissors")&& 
                    player_choice.equals
            ("Rock"))
            {
                resultsAccumulator += "<h2><br>Rock crushes scissors</h2>"
                        + "<br><br>"+" You win!";
                resultIcon = new ImageIcon("rockCrushScissor.png");
                wins += 1;
            }
            else
            {
                resultsAccumulator += "<h2><br>Scissors cuts paper </h2>"
                        + "<br><br>"+" You lose!";
                resultIcon = new ImageIcon("scissorCutPaper.png");
                losses += 1;
            }
         
            JOptionPane.showMessageDialog(null,
                    resultsAccumulator,"End of round results " + 
                            "       Adetola Aladekoba", 0,
                            resultIcon);
            counter++;
        }
        
       ImageIcon scoreBoard = new ImageIcon("RPS2.png");
       String score_board = "<html> Final score board for 3 games<br>"+
               "<h2>Wins: "+wins+"<br>"+"\n"+"Losses:" +losses+"<br>"+"\n"+ 
               "Ties:"+ ties+"</h2>"+"<br>";
       JOptionPane.showMessageDialog(null, score_board, 
               "Score Board               Adetola Aladekoba",0, 
               scoreBoard);
      
       String termination_message = "<html><h2>Process complete and program"
               + " ending!</h2>";
       ImageIcon terminationIcon = new ImageIcon("RPS.png");
       JOptionPane.showMessageDialog(null,termination_message,
               "Termination Message                Adetola Aladekoba" 
               ,0, terminationIcon);
    }
}
