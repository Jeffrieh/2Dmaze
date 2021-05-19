package Maze;

import Maze.Generators.DFS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MazePanel extends JPanel {
    private final List<Cell> grid = new ArrayList<Cell>();

    public MazePanel(int size) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                grid.add(new Cell(x, y));
            }
        }

        DFS solver = new DFS(grid, this);
    }

    //    public void paint(Graphics g) {
//        super.paint(g);
//        for (Cell c : grid) {
//            c.draw(g);
//        }
//        grid.get(0).displayAsColor(g, Color.GREEN);
//        grid.get(grid.size() - 1).displayAsColor(g, Color.YELLOW);
//    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Cell c : grid) {
            c.draw(g);
        }
        grid.get(0).displayAsColor(g, Color.GREEN);
        grid.get(grid.size() - 1).displayAsColor(g, Color.YELLOW);
    }
}
