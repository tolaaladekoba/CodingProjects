/*
 * Purpose of class: It is StackBrick class serving as a subclass and handling 
   the rotation of the brick
 * Date last modified: 11-22-2023
 * Author: Damilola Osoba
 */
import java.awt.Color;

public class StackBrick extends TetrisBrick {
    
    int rowPosition;
    int columnPosition;

    public StackBrick(int centerColumn) {
        
        super(centerColumn);
        colorNum = 5;
        initPosition(centerColumn);
        orientation = 0;
    }

    @Override
    public void initPosition(int centerColumn) {
        
        position = new int[][]{
            {0, centerColumn},
            {1, centerColumn},
            {1, centerColumn - 1},
            {1, centerColumn + 1}
        };
    }

    public void rotate() {
        
        rowPosition = position[1][0];
        columnPosition = position[1][1];
        int numberOfOrientation = 4;
        int currentOrientation = orientation + 1;
        if (currentOrientation == numberOfOrientation) {
            currentOrientation = 0;
            }

        switch (orientation) {
            case 0:
                position = new int[][]{
                    {rowPosition, columnPosition + 1},
                    {rowPosition, columnPosition},
                    {rowPosition - 1, columnPosition},
                    {rowPosition + 1, columnPosition}
                };
                break;
            case 1:
                position = new int[][]{
                    {rowPosition + 1, columnPosition},
                    {rowPosition, columnPosition},
                    {rowPosition, columnPosition + 1},
                    {rowPosition, columnPosition - 1}
                };
                break;
            case 2:
                position = new int[][]{
                    {rowPosition, columnPosition - 1},
                    {rowPosition, columnPosition},
                    {rowPosition + 1, columnPosition},
                    {rowPosition - 1, columnPosition}
                };
                break;
            case 3:
                position = new int[][]{
                    {rowPosition - 1, columnPosition},
                    {rowPosition, columnPosition},
                    {rowPosition, columnPosition - 1},
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
