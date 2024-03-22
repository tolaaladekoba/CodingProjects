/*
 * Purpose of class:The Tetrisbrick class represents a Tetris brick with 
   properties like color and position.
  for the Tetris game board.
 * Date last modified: 11/7/2023
 * Author: Damilola Osoba
 */
import java.awt.Color;

public abstract class TetrisBrick {
    
    public int[][] position = new int[4][2];
    public int numSegments = 4;
    public int colorNum;
    public int orientation;

    public TetrisBrick(int centerColumn) {
        
        initPosition(centerColumn);
    }

    public abstract void rotate();

    public abstract void unrotate();

    public int getNumSegments(){
        
        return numSegments;
    }
   
    public int getColorNumber() {
        
        return colorNum;
    }

    public abstract void initPosition(int centerColumn);

    public void moveLeft() {
        
        for (int segment = 0; segment < numSegments; segment++) {
            position[segment][1]--;
        }
    }

    public void moveRight() {
        
        for (int segment = 0; segment < numSegments; segment++) {
            position[segment][1]++;
        }
    }

    public void moveDown() {
        
        for (int segment = 0; segment < numSegments; segment++) {
            position[segment][0]++;
        }
    }

    public void moveUp() {
        
        for (int segment = 0; segment < numSegments; segment++) {
            position[segment][0]--;
        }
    }
}
