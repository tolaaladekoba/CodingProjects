/*
 Adetola Aladekoba
 Using if-else statemennts,2D arrays,custom methods,random number generator, 
 and JOptionPane class to create a battleship game
 11/17/2023
*/

import javax.swing.*;
import java.util.*;

public class BattleShipDisplay {
    
    
    public static void main(String[] args) {
        
        String welcomeMessage ="This program is a battleship game that generate"
                + " random ships till you decide to stop.\n If you want to "
                + "continue playing the game, click on \"Stop Already\"\n and "
                + "if you want to continue playing select \"Show Another Board"
                + "\"";
        JOptionPane.showMessageDialog (null, welcomeMessage,
                "Welcome Messsage",
                JOptionPane.INFORMATION_MESSAGE);
        int rows =10;
        int columns = 10;
        String[][] board = generateBoard(rows, columns);
        int option = displayBoard(board);

        while (true) {
        board = generateBoard(rows, columns);
        
        if(option == 0)
              break;
        else
            option = displayBoard(board);
                    }
        
    String terminationMessage ="Process complete and program terminating";
    JOptionPane.showMessageDialog (null, terminationMessage,
                "Termination Messsage",
                JOptionPane.INFORMATION_MESSAGE);   
    }

    public static String[][] generateBoard(int rows, int columns) {
        String[][] board = new String[rows][columns];

        for (int row = 0; row < rows; row++) 
        {
            for (int column = 0; column < columns; column++) 
            {
                board[row][column] = "  -  ";
            }
        }

        Random random = new Random();
        int startCol = random.nextInt(columns - 4); 
        int startRow = random.nextInt(rows-4);
        int direction = random.nextInt(2);
        if (direction == 0)
        {
        for (int row = 0; row < 5; row++)
            {
            board[startRow][startCol + row] = "  X  "; 
            }
        }
        else{
            for (int row = 0; row < 5; row++) 
            {
            board[startRow+row][startCol] = "  X  "; 
            }
        }
        return board;
    }

    public static int displayBoard(String[][] board) {
        String display = "";

        for (int row =0;row<board.length;row++) {
            for (int col =0;col<board[0].length;col++) {
                display += board[row][col];
            }
            display += "\n";
        }
        
        String[]choices ={"Stop Already!", "Show Another Board"};
       
        int userOption = JOptionPane.showOptionDialog(null,
                display, "New Game Board",0,
                JOptionPane.INFORMATION_MESSAGE,null, 
                choices, choices[0]);
        
        return userOption;
    }
}



