/*
 * Purpose of program: Responsible for the logic of the game.
 * Date last modified: 11/7/2023.
 * Author: Damilola Osoba
 */

import java.util.Random;

public class TetrisGame {

    private int rows;
    private int cols;
    private Random randomGen;
    public TetrisBrick fallingBrick;
    private int[][] background;
    private int numBrickTypes = 7;

    public TetrisGame(int rows, int cols) {
        
        this.rows = rows;
        this.cols = cols;
        this.randomGen = new Random();
        this.background = new int[rows][cols];
        newGame();
    }

    public void initBoard() {
        
        background = new int[rows][cols];
    }

    public void newGame() {
        
        initBoard();
        spawnBrick();
    }

    public int fetchBoardPosition(int rows, int cols) {
        
        return background[rows][cols];
    }

    public boolean validateMove() {
        
        for (int seg = 0; seg < fallingBrick.getNumSegments(); seg++) {
            int row = getSegRow(seg);
            int col = getSegCol(seg);

            if (row >= rows || col < 0 || col >= cols || background[row][col] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean makeMove(String moveCode) {
        
        if (moveCode.equals("L")) {
            fallingBrick.moveLeft();
            if (!validateMove()) {
                fallingBrick.moveRight();
            }
        } else if (moveCode.equals("R")) {
            fallingBrick.moveRight();
            if (!validateMove()) {
                fallingBrick.moveLeft();
            }
        } else if (moveCode.equals("U")) {
            fallingBrick.rotate();
            if (!validateMove()) {
                fallingBrick.unrotate();
            }
        } else if (moveCode.equals("D")) {
            fallingBrick.moveDown();
            if (!validateMove()) {
                fallingBrick.moveUp();
                transferColor();
                spawnBrick();
            }
        }
        return true;
    }

    public int getRows() {
        
        return rows;
    }

    public int getCols() {
        
        return cols;
    }

    public void transferColor() {
        
        for (int segment = 0; segment < fallingBrick.getNumSegments(); segment++) {
            int segRow = getSegRow(segment);
            int segCol = getSegCol(segment);
            int brickColor = fallingBrick.getColorNumber();
            background[segRow][segCol] = brickColor;
        }
    }

    public int getSegRow(int segmentNumber) {
        
        return fallingBrick.position[segmentNumber][0];
    }

    public int getSegCol(int segmentNumber) {
        
        return fallingBrick.position[segmentNumber][1];
    }

    public TetrisBrick getFallingBrick() {
        
        return fallingBrick;
    }

    public int getNumSegs() {
        
        return fallingBrick.getNumSegments();
    }

    public int getFallingBrickColor() {
        
        return fallingBrick.getColorNumber();
    }

    public void spawnBrick() {
        
        int randomBrickType = randomGen.nextInt(2, 8);
        int horizontalCenter = (cols) / 2;

        switch (randomBrickType) {
            case 2:
                fallingBrick = new ElBrick(horizontalCenter);
                break;
            case 3:
                fallingBrick = new JayBrick(horizontalCenter);
                break;
            case 4:
                fallingBrick = new LongBrick(horizontalCenter);
                break;
            case 5:
                fallingBrick = new SquareBrick(horizontalCenter);
                break;
            case 6:
                fallingBrick = new StackBrick(horizontalCenter);
                break;
            case 7:
                fallingBrick = new ZeeBrick(horizontalCenter);
                break;
            case 8:
                fallingBrick = new EssBrick(horizontalCenter);
                break;
            default:
                break;
        }
    }
}
