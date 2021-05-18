package Maze;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cell extends JPanel {

    public static int WIDTH = 10;
    public static int HEIGHT = 10;
    public boolean active = false;
    public boolean visited;

    public int row;
    public int col;
    public boolean[] walls = new boolean[4];

    public Map<String, Cell> neighbours;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        int x = col * WIDTH;
        int y = row * WIDTH;

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
            g.drawLine(x + WIDTH, y, (x + WIDTH), (y + HEIGHT));
        }
        //bottom
        if(walls[2]){
            g.drawLine(x, y + HEIGHT, (x + WIDTH), (y + HEIGHT));
        }
        //left
        if(walls[3]){
            g.drawLine(x, y, x, (y + HEIGHT));
        }
    }

    public Cell(int i,int j){
    this.row = i;
    this.col = j;

    this.visited = false;

    walls[0] = true;
    walls[1] = true;
    walls[2] = true;
    walls[3] = true;
    neighbours = new HashMap<>();


    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "active=" + active +
                ", visited=" + visited +
                ", row=" + row +
                ", col=" + col +
//                ", walls=" + Arrays.toString(walls) +
//                ", neighbours=" + neighbours.entrySet().stream()
//                .filter(entry -> entry.getValue() != null)
//                .map(x -> x.getRow())
//                .collect(Collectors.toList()) +
                '}';
    }
}
