/*
 * Purpose of class: It is EssBrick class serving as a subclass and handling 
   the rotation of the brick
 * Date last modified: 11-7-2023
 * Author: Damilola Osoba
 */
import java.awt.Color;

public class EssBrick extends TetrisBrick {
    
    int rowPosition;
    int columnPosition;

    public EssBrick(int centerColumn) {
        
        super(centerColumn);
        colorNum = 7;
        initPosition(centerColumn);
        orientation = 0; 
    }

    @Override
    public void initPosition(int centerColumn) {
        
        position = new int[][] {
            {0, centerColumn},
            {0, centerColumn + 1},
            {1, centerColumn},
            {1, centerColumn - 1} 
        };
    }

    public void rotate() {
        
        rowPosition = position[1][0];
        columnPosition = position[1][1];
        int numberOfOrientation = 2;
        int currentOrientation = orientation + 1;
        if (currentOrientation == numberOfOrientation) {
            currentOrientation = 0;
            }

        if (orientation == 0) {
            position = new int[][]{
                {rowPosition + 1, columnPosition},
                {rowPosition, columnPosition},
                {rowPosition, columnPosition - 1},
                {rowPosition - 1, columnPosition - 1}
            };
        } else if (orientation == 1) {
            position = new int[][]{
                {rowPosition, columnPosition + 1},
                {rowPosition, columnPosition},
                {rowPosition + 1, columnPosition},
                {rowPosition + 1, columnPosition - 1}
            };
        }
        orientation = currentOrientation;
    }

    public void unrotate() {
        
         rotate(); 
         rotate(); 
    }
}
