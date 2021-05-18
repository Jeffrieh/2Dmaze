package Maze;

import java.awt.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Maze{
    public int size;

    Cell maze[][];
    Cell current;

    public Maze(int size){
        this.size = size;
        maze = new Cell[size][size];
        generate();
    }

    public Cell findCellAt(int x, int y){
        if(x > size * Cell.WIDTH || y > size * Cell.HEIGHT){
            return null;
        }

        int a = (int) Math.floor(x / 10);
        int b = (int) Math.floor(y / 10);

        return maze[a][b];
    }

    public void setEndingPoint(Cell end){
        //start solving
        System.out.println(end);
//        ArrayDeque<Cell> q = new ArrayDeque<Cell>();
//        Cell root = maze[0][0];
//        q.add(root);
//        while(!q.isEmpty()){
//            Cell cur = q.element();
//            if(cur == end){
//                return;
//            }else{
//                getUnvisitedNeighbours(cur);
//            }
//
//        }
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Cell cur = maze[row][col];
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
        if(x.row == y.row){
            //if x is left of y
            if(x.col < y.col){
                x.walls[1] = false;
                y.walls[3] = false;
            }else{
                x.walls[3] = false;
                y.walls[1] = false;
            }
        }else{
            //if x is above y
            if(x.row < y.row){
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

    public HashMap<String, Cell> getNeighbours(Cell c){
        HashMap<String, Cell> neighbours = new HashMap<>();
        try{
            neighbours.put("NORTH", getCellAt(c.row - 1, c.col));
            neighbours.put("EAST", getCellAt(c.row, c.col + 1));
            neighbours.put("SOUTH", getCellAt(c.row + 1, c.col));
            neighbours.put("WEST", getCellAt(c.row , c.col - 1));
        }catch (Exception e){
            System.out.println(e);
        }

        return neighbours;
    }

    public List<Cell> getUnvisitedNeighbours(Cell c){
        return getNeighbours(c).values().stream().filter(x -> x != null && x.visited == false).collect(Collectors.toList());
    }

    Cell getCellAt(int row, int col){
        try{
            return maze[row][col];
        }catch (Exception e){
            return null;
        }
    }

    void generate(){
        Stack<Cell> s = new Stack();
        for(int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                try{
                    Cell c = new Cell(row, col);
                    maze[row][col] = c;
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        }

        current = maze[0][0];
        s.push(current);

        while(!s.isEmpty()){
            Cell cur = s.pop();
            cur.visited = true;

            List<Cell> neighbours = getUnvisitedNeighbours(cur);
            System.out.println("n : " + neighbours);
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
