package Maze;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MazeGUI
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
            int size = 100;
            Maze maze = new Maze(size);
            JFrame frame = new JFrame("Maze");
            MazePanel panel = new MazePanel(maze);
            JScrollPane scrollPane = new JScrollPane(panel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
    }
}