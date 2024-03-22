/*
 * Purpose of class: It is ZeeBrick class serving as a subclass and handling 
   the rotation of the brick
 * Date last modified: 11-22-2023
 * Author: Damilola Osoba
 */
public class ZeeBrick extends TetrisBrick {
    
    int rowPosition;
    int columnPosition;

    public ZeeBrick(int centerColumn) {
        
        super(centerColumn);
        colorNum = 6;
        initPosition(centerColumn);
        orientation = 0;
    }

    @Override
    public void initPosition(int centerColumn) {

        position = new int[][] {
            {0, centerColumn - 1},
            {0, centerColumn},
            { 1, centerColumn},
            { 1, centerColumn + 1} 
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
                {rowPosition - 1, columnPosition},
                {rowPosition, columnPosition},
                {rowPosition, columnPosition - 1},
                {rowPosition + 1, columnPosition - 1}
            };
        } else if (orientation == 1) {
            position = new int[][]{
                {rowPosition, columnPosition - 1},
                {rowPosition, columnPosition},
                {rowPosition + 1, columnPosition},
                {rowPosition + 1, columnPosition + 1}
            };
        }

        orientation = currentOrientation;
    }

    public void unrotate() {
        
        rowPosition = position[1][0];
        columnPosition = position[1][1];
        int numberOfOrientation = 2;
        int currentOrientation = (orientation + 1) % numberOfOrientation;

        if (orientation == 0) {
            position = new int[][]{
                {rowPosition - 1, columnPosition},
                {rowPosition, columnPosition},
                {rowPosition, columnPosition - 1},
                {rowPosition + 1, columnPosition - 1}
            };
        } else if (orientation == 1) {
            position = new int[][]{
                {rowPosition, columnPosition - 1},
                {rowPosition, columnPosition},
                {rowPosition + 1, columnPosition},
                {rowPosition + 1, columnPosition + 1}
            };
        }

        orientation = currentOrientation;
    }
}
