package Maze;

public class Cell {
    public int i;
    public int j;
    private boolean[] walls = new boolean[3];

    void checkNeighbours(){

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
