package Maze.Solvers;

import Maze.Cell;
import Maze.MazePanel;

import javax.swing.*;
import java.util.List;
import java.util.Stack;

public class BFS {
    private final Stack<Cell> stack = new Stack();
    private final List<Cell> grid;
    public Cell current;

    public BFS(final List<Cell> grid, final MazePanel panel) {
        this.grid = grid;
        this.current = grid.get(0);

        final Timer timer = new Timer(1, null);
        timer.addActionListener(e -> {
            if (!grid.stream().allMatch((c) -> c.isVisited())) {
                this.carve();
            } else {
                this.current = null;
                timer.stop();
            }

            panel.repaint();
            timer.setDelay(1);
        });
        timer.start();
    }

    private void carve() {
        this.current.setVisited(true);
        Cell next = this.current.getUnvisitedNeighbour(this.grid);
        System.out.println(next);
        if (next != null) {
            this.stack.push(this.current);
            Cell.removeWallBetweenTwoCells(this.current, next);
            this.current = next;
        } else if (!this.stack.isEmpty()) {
            try {
                this.current = this.stack.pop();
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        }

    }
}
