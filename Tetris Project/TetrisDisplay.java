/*
 * Purpose of class: This is the display class
 * Date last modified: 11-22-2023
 * Author: Damilola Osoba
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TetrisDisplay extends JPanel {

    private TetrisGame game;
    private int start_x = 100;
    private int start_y = 50;
    private int cell_size=20;
    private Timer timer;
    private Color[] colors = new Color[]{
            Color.BLACK, Color.WHITE, Color.BLUE,
            Color.YELLOW, Color.PINK, Color.GREEN,
            Color.ORANGE, Color.RED, Color.BLACK, Color.GRAY
    };
    private boolean pause = false;

    public TetrisDisplay( TetrisGame tetrisGame) {
        
      
        this.game = tetrisGame;
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                translateKey( e.getKeyCode());
            }
        });

        timer = new Timer(500, e -> {
            if (!pause) {
                cycleMove();
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        drawWell(g);
        drawBackground(g);
        drawFallingBrick(g);
    }

    private void drawWell(Graphics g) {
        
        int numRows = game.getRows();
        int numCols = game.getCols();

        g.setColor(colors[0]);
        g.fillRect(start_x, start_y, cell_size, numRows * cell_size);
        g.fillRect(start_x + cell_size + (cell_size * numCols), start_y,
                cell_size, numRows * cell_size);

        int bottomRectWidth = (2*cell_size) + (cell_size * numCols);
        int bottomRectY = start_y+ (numRows * cell_size);

        g.fillRect(start_x, bottomRectY, bottomRectWidth, cell_size);

        int whiteSpaceWidth = numCols * cell_size;
        int whiteSpaceHeight = numRows * cell_size;

        g.setColor(colors[1]);
        g.fillRect(start_x + cell_size, start_y, whiteSpaceWidth, 
                whiteSpaceHeight);
    }

    private void drawBackground(Graphics g) {
        
        int numRows = game.getRows();
        int numCols = game.getCols();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int brickX = start_x + cell_size + col * cell_size;
                int brickY = start_y + row * cell_size;
                int brickColor = game.fetchBoardPosition(row, col);

                if (brickColor != 0) {
                    g.setColor(colors[brickColor]);
                    g.fillRect(brickX, brickY, cell_size, cell_size);

                    g.setColor(colors[0]);
                    g.drawRect(brickX, brickY, cell_size, cell_size);
                }
            }
        }
    }

    private void drawFallingBrick(Graphics g) {
        
        TetrisBrick fallingBrick = game.getFallingBrick();
        if (fallingBrick != null) {
            for (int segmentNumber = 0; segmentNumber < fallingBrick.getNumSegments(); segmentNumber++) {
                int segRow = game.getSegRow(segmentNumber);
                int segCol = game.getSegCol(segmentNumber);
                int brickX = start_x + cell_size + segCol * cell_size;
                int brickY = start_y + segRow * cell_size;

                Color brickColor = colors[fallingBrick.getColorNumber()];

                g.setColor(brickColor);
                g.fillRect(brickX, brickY, cell_size, cell_size);

                g.setColor(colors[0]);
                g.drawRect(brickX, brickY, cell_size, cell_size);
            }
        }
    }

    private void cycleMove() {
        
        game.makeMove("D");
        repaint();
    }

    private void translateKey( int keyCode) {
        
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                game.makeMove("L");
                break;
            case KeyEvent.VK_RIGHT:
                game.makeMove("R");
                break;
            case KeyEvent.VK_DOWN:
                game.makeMove("D");
                break;
            case KeyEvent.VK_UP:
                game.makeMove("U");
                break;
            case KeyEvent.VK_N:
                game.newGame();
                break;
            case KeyEvent.VK_SPACE:
                pause = !pause;
                break;
            default:
                break;
        }

        repaint();
    }
}
