package Maze;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private int squareX = 50;
    private int squareY = 50;
    public static int WIDTH = 5;
    public static int HEIGHT = 5;
    public boolean active = false;

    public int i;
    public int j;
    private boolean[] walls = new boolean[4];

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        if(active){
            g.setColor(Color.RED);
            g.fillRect(squareX,squareY,WIDTH,HEIGHT);
        }

        int x = i * WIDTH;
        int y = j * WIDTH;

        //top
        if(walls[0]){
            g.drawLine(x, y, (x + WIDTH), (y));
        }
        //right
        if(walls[1]){
            g.drawLine(x + WIDTH, y, (x + WIDTH), (y + WIDTH));
        }
        //bottom
        if(walls[2]){
            g.drawLine(x, y + WIDTH, (x + WIDTH), (y + WIDTH));
        }
        //left
        if(walls[3]){
            g.drawLine(x, y, x, (y + WIDTH));

        }

    }

    public Cell(int i,int j){
    this.i = i;
    this.j = j;

    walls[0] = true;
    walls[1] = true;
    walls[2] = true;
    walls[3] = true;
    }
}
