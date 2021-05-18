package Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MazePanel extends JPanel implements MouseListener
{
    private Maze maze;

    public MazePanel(Maze m)
    {
        maze = m;
        addMouseListener(this);
    }


    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        setBackground(Color.white);
        this.setPreferredSize(maze.windowSize());
        maze.draw(page);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        maze.setEndingPoint(maze.findCellAt(e.getX(), e.getY()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
