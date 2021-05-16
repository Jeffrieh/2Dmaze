package Maze;

import java.awt.*;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Maze extends Canvas{
    public int size;
    Cell maze[][];
    Cell current;

    public Maze(int size){
        this.size = size;
        maze = new Cell[size][size];
    }

    void checkNeighbours(){}

    public static void main(String[] args) {
        int size = 500;
        JFrame frame = new JFrame("Maze");
        Canvas canvas = new Maze(size);
        canvas.setSize(size, size);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        g.fillOval(100, 100, 200, 200);
    }

    void generate(){
        for(int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                maze[row][col] = new Cell(row,col);
            }
        }
        //start at the top left.
        current = maze[0][0];
    }
}
