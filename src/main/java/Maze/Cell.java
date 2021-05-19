package Maze;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Cell extends JComponent {

    public static int WIDTH = 5;
    public static int HEIGHT = 5;
    public boolean active = false;

    public boolean visited;
    private boolean path = false;
    private boolean deadEnd = false;

    private Cell parent;
    private int distance;

    public int row;
    public int col;
    private boolean[] walls = new boolean[]{true, true, true, true};

    public Map<String, Cell> neighbours;

    protected void draw(Graphics g) {

        int x = col * WIDTH;
        int y = row * WIDTH;

        if (this.visited) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 20, 20);
        }

        if (this.path) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 20, 20);
        } else if (this.deadEnd) {
            g.setColor(Color.RED);
            g.fillRect(x, y, 20, 20);
        }

        g.setColor(Color.BLACK);

        if (walls[0]) {
            g.drawLine(x, y, (x + WIDTH), y);
        }
        if (walls[1]) {
            g.drawLine(x + WIDTH, y, (x + WIDTH), (y + HEIGHT));
        }
        if (walls[2]) {
            g.drawLine(x, y + HEIGHT, (x + WIDTH), (y + HEIGHT));
        }
        if (walls[3]) {
            g.drawLine(x, y, x, (y + HEIGHT));
        }
    }

    public boolean isVisited() {
        return visited;
    }

    public static void removeWallBetweenTwoCells(Cell x, Cell y) {
        //same row
        if (x.row == y.row) {
            //if x is left of y
            if (x.col < y.col) {
                x.walls[1] = false;
                y.walls[3] = false;
            } else {
                x.walls[3] = false;
                y.walls[1] = false;
            }
        } else {
            //if x is above y
            if (x.row < y.row) {
                x.walls[2] = false;
                y.walls[0] = false;
            } else {
                x.walls[0] = false;
                y.walls[2] = false;
            }
        }
    }

    private Cell checkNeighbourInGridBounds(List<Cell> grid, Cell neighbour) {
        return grid.contains(neighbour) ? grid.get(grid.indexOf(neighbour)) : null;
    }

    public List<Cell> getUnvisitedNeighboursList(List<Cell> grid) {
        List<Cell> neighbours = new ArrayList(4);
        Cell top = this.checkNeighbourInGridBounds(grid, new Cell(this.row - 1, this.col));
        Cell right = this.checkNeighbourInGridBounds(grid, new Cell(this.row, this.col + 1));
        Cell bottom = this.checkNeighbourInGridBounds(grid, new Cell(this.row + 1, this.col));
        Cell left = this.checkNeighbourInGridBounds(grid, new Cell(this.row, this.col - 1));

        if (top != null && !top.visited) {
            neighbours.add(top);
        }

        if (right != null && !right.visited) {
            neighbours.add(right);
        }

        if (bottom != null && !bottom.visited) {
            neighbours.add(bottom);
        }

        if (left != null && !left.visited) {
            neighbours.add(left);
        }

        return neighbours;
    }

    private Cell randomNeighbour(List<Cell> neighbours) {
        return neighbours.size() > 0 ? (Cell) neighbours.get((new Random()).nextInt(neighbours.size())) : null;
    }

    public Cell getUnvisitedNeighbour(List<Cell> grid) {
        List<Cell> neighbours = this.getUnvisitedNeighboursList(grid);
        System.out.println("n : " + neighbours);
        return neighbours.size() == 1 ? neighbours.get(0) : this.randomNeighbour(neighbours);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Cell(int i, int j) {
        this.row = i;
        this.col = j;
        this.visited = false;
    }

    public void displayAsColor(Graphics g, Color color) {
        int x = this.col * WIDTH;
        int y = this.row * HEIGHT;
        g.setColor(color);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Cell other = (Cell) obj;
            if (this.row != other.row) {
                return false;
            } else {
                return this.col == other.col;
            }
        }
    }

    @Override
    public String toString() {
        return "Cell{" +
                "active=" + active +
                ", visited=" + visited +
                ", row=" + row +
                ", col=" + col +
                ", walls=" + Arrays.toString(walls) +
//                ", neighbours=" + neighbours.entrySet().stream()
//                .filter(entry -> entry.getValue() != null)
//                .map(x -> x.getRow())
//                .collect(Collectors.toList()) +
                '}';
    }
}
