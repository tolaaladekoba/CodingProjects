/*
 * Purpose of class: It is SquareBrick class serving as a subclass and handling 
   the rotation of the brick
 * Date last modified: 11-7-2023
 * Author: Damilola Osoba
 */
import java.awt.Color;

public class SquareBrick extends TetrisBrick {
    
    public SquareBrick(int centerColumn) {
        
        super(centerColumn);
        colorNum = 4;
        initPosition(centerColumn);
    }

    @Override
    public void initPosition(int centerColumn) {
        
        position = new int[][] {
            {0, centerColumn - 1},
            {0, centerColumn},
            {1, centerColumn - 1},
            {1, centerColumn}
        };
    }

    @Override
    public void rotate() {
       
    }

    @Override
    public void unrotate() {
       
    }
}
