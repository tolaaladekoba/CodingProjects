/*
 * Purpose of class: This is the window class
 * Date last modified: 11-22-2023
 * Author: Damilola Osoba
 */
import javax.swing.*;
import java.awt.*;

public class TetrisWindow extends JFrame {
    
    private TetrisDisplay display;
    private int win_width = 500; 
    private int win_height = 600; 
    private int game_rows = 15; 
    private int game_cols = 10; 
    private TetrisGame game; 
  
    public TetrisWindow() {
       
    setTitle("Tetris Game       Damilola Osoba");
    setSize(win_width, win_height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game = new TetrisGame(game_rows, game_cols);

    display = new TetrisDisplay( game); 
    add(display); 
    setVisible(true);
    }  
   
    public static void main(String[] args) { 
        
        TetrisWindow display_window = new TetrisWindow();
    }  
}
