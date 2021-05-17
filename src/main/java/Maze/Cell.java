package Maze;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    public static int WIDTH = 30;
    public static int HEIGHT = 30;
    public boolean active = false;
    public boolean visited;

    public int i;
    public int j;
    public boolean[] walls = new boolean[4];


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        int x = i * WIDTH;
        int y = j * WIDTH;

        if(active){
            g.setColor(Color.RED);
            g.fillRect(x,y,WIDTH,HEIGHT);
        }

        //top
        if(walls[0]){
            g.drawLine(x, y, (x + WIDTH), y);
        }
        //right
        if(walls[1]){
            g.drawLine(x + WIDTH, y, (x + WIDTH), (y + WIDTH));
        }
        //bottom
        if(walls[2]){
            g.drawLine(x + HEIGHT, y + WIDTH, (x + WIDTH), (y + WIDTH));
        }
        //left
        if(walls[3]){
            g.drawLine(x, y, x, (y + WIDTH));
        }
    }

    public Cell(int i,int j){
    this.i = i;
    this.j = j;

    this.visited = false;

    walls[0] = true;
    walls[1] = true;
    walls[2] = true;
    walls[3] = true;
    }
}
