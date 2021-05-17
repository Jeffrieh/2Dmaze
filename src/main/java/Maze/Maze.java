package Maze;

import java.awt.*;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Maze{
    public int size;

    Cell maze[][];
    Cell current;

    public Maze(int size){
        this.size = size;
        maze = new Cell[size][size];
        generate();
    }

    public void draw(Graphics g)
    {
        System.out.println("drawing!");
        g.setColor(Color.BLACK);

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Cell cur = maze[row][col];


                //top

                cur.paintComponent(g);

            }
        }
    }

    public Dimension windowSize()
    {
        return new Dimension(size * Cell.HEIGHT, size * Cell.WIDTH);
    }

    void generate(){
        for(int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                maze[row][col] = new Cell(row,col);
            }
        }
        //start at the top left.
        current = maze[0][0];
        current.active = true;
    }
}
