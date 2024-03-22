/*
 * Purpose of class: It is LongBrick class serving as a subclass and handling 
   the rotation of the brick
 * Date last modified: 11-22-2023
 * Author: Damilola Osoba
 */
public class LongBrick extends TetrisBrick {
    
    int rowPosition;
    int columnPosition;

    public LongBrick(int centerColumn) {
        
        super(centerColumn);
        colorNum = 3;
        initPosition(centerColumn);
    }

    @Override
    public void initPosition(int centerColumn) {
        
        position = new int[][] {
            {0, centerColumn - 2},
            {0, centerColumn - 1},
            {0, centerColumn},
            {0, centerColumn + 1}
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

        switch (orientation) {
            case 0:
                position = new int[][] {
                    {rowPosition - 1, columnPosition},
                    {rowPosition, columnPosition},
                    {rowPosition + 1, columnPosition},
                    {rowPosition + 2, columnPosition}
                };
                break;
            case 1:
                position = new int[][] {
                    {rowPosition, columnPosition - 1},
                    {rowPosition, columnPosition},
                    {rowPosition, columnPosition + 1},
                    {rowPosition, columnPosition + 2}
                };
                break;
        }

        orientation = currentOrientation;
    }

    public void unrotate() {
        
        rotate();
}
}