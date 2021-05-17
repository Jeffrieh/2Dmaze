package Maze;

import java.awt.*;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;
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
        g.setColor(Color.BLACK);

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Cell cur = maze[row][col];
                //paint the cell
                cur.paintComponent(g);
            }
        }
    }

    public Dimension windowSize()
    {
        return new Dimension(size * Cell.HEIGHT, size * Cell.WIDTH);
    }

    public void removeWallBetweenTwoCells(Cell x, Cell y){

        //get the orientation of two cells;

        //same row
        if(x.j == y.j){
            //if x is left of y
            if(x.i < y.i){
                x.walls[1] = false;
                y.walls[3] = false;
            }else{
                x.walls[3] = false;
                y.walls[1] = false;
            }
        }else{
            //if x is above y
            if(x.j < y.j){
                x.walls[2] = false;
                y.walls[0] = false;
            }else{
                x.walls[0] = false;
                y.walls[2] = false;
            }
        }

        x.repaint();
        y.repaint();
    }

    public ArrayList<Cell> getUnvisitedNeighbours(Cell c){

        ArrayList<Cell> neighbours = new ArrayList<>();

        //TODO make this better.
        //top
        try{
            System.out.println("top");
            if(maze[c.i - 1][c.j] != null && maze[c.i - 1][c.j].visited == false){
                neighbours.add(maze[c.i - 1][c.j]);
            }else{
                System.out.println("couldnt add col : " + (c.i - 1) + " row : " + c.j + maze[c.i - 1][c.j].visited);
            }
        }catch (Exception e){
            System.out.println(e);
        }


        //right
        try{
            System.out.println("right");

            if(maze[c.i][c.j + 1] != null && maze[c.i][c.j + 1].visited == false){
                neighbours.add(maze[c.i][c.j + 1]);
            }
        }catch (Exception e){

        }

        //bottom
        try{
            System.out.println("bottom");
            if(maze[c.i + 1][c.j] != null && maze[c.i + 1][c.j].visited == false){
                neighbours.add(maze[c.i + 1][c.j]);
            }
        }catch (Exception e){

        }

        //left
        try{
            System.out.println("left");
            if(maze[c.i][c.j - 1] != null && maze[c.i][c.j - 1].visited == false){
                neighbours.add(maze[c.i][c.j - 1]);
            }
        }catch (Exception e){

        }

        return neighbours;

    }

    void generate(){
        Stack<Cell> s = new Stack();
        for(int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                maze[row][col] = new Cell(row,col);
            }
        }

        current = maze[0][0];
        s.push(current);

        while(!s.isEmpty()){
            Cell cur = s.pop();
            cur.visited = true;

            ArrayList<Cell> neighbours = getUnvisitedNeighbours(cur);

            if(!neighbours.isEmpty()){
                s.push(cur);
                int index = (int)(Math.random() * neighbours.size());
                removeWallBetweenTwoCells(cur, neighbours.get(index));
                neighbours.get(index).visited = true;
                s.push(neighbours.get(index));
            }
        }
    }
}
