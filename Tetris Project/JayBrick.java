/*
 * Purpose of class: It is JayBrick class serving as a subclass and handling 
   the rotation of the brick
 * Date last modified: 11-7-2023
 * Author: Damilola Osoba
 */
import java.awt.Color;

public class JayBrick extends TetrisBrick {
    
    int rowPosition;
    int columnPosition;

    public JayBrick(int centerColumn) {
        
        super(centerColumn);
        colorNum = 2;
        initPosition(centerColumn);
        orientation = 0;
    }

    @Override
    public void initPosition(int centerColumn) {
        
        position = new int[][] {
            {2, centerColumn - 1},
            {2, centerColumn},
            {1, centerColumn},
            {0, centerColumn}
        };
    }

    public void rotate() {
        
        rowPosition = position[2][0];
        columnPosition = position[2][1];
        int numberOfOrientation = 4;
        int currentOrientation = orientation + 1;
        if (currentOrientation == numberOfOrientation) {
            currentOrientation = 0;
            }

        switch (orientation) {
            case 0:
                position = new int[][] {
                    {rowPosition + 2, columnPosition},
                    {rowPosition, columnPosition + 1},
                    {rowPosition, columnPosition},
                    {rowPosition + 1, columnPosition}
                };
                break;
            case 1:
                position = new int[][] {
                    {rowPosition + 1, columnPosition + 1},
                    {rowPosition, columnPosition + 1},
                    {rowPosition, columnPosition},
                    {rowPosition, columnPosition - 1}
                };
                break;
            case 2:
                position = new int[][] {
                    {rowPosition + 1, columnPosition - 1},
                    {rowPosition + 1, columnPosition},
                    {rowPosition, columnPosition},
                    {rowPosition - 1, columnPosition}
                };
                break;
            case 3:
                position = new int[][] {
                    {rowPosition - 1, columnPosition - 1},
                    {rowPosition, columnPosition - 1},
                    {rowPosition, columnPosition},
                    {rowPosition, columnPosition + 1}
                };
                break;
        }
        orientation = currentOrientation;
    }

    public void unrotate() {
        
        rotate();
        rotate();
        rotate();
    }
}
