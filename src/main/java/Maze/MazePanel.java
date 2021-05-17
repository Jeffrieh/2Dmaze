package Maze;

import javax.swing.*;
import java.awt.*;

class MazePanel extends JPanel
{
    private Maze maze;

    public MazePanel(Maze m)
    {
        maze = m;
    }

    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        setBackground(Color.white);
        this.setPreferredSize(maze.windowSize());
        maze.draw(page);
    }
}
