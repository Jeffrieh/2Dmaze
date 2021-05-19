package Maze;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MazeGUI
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
            JFrame frame = new JFrame("Maze");
            MazePanel panel = new MazePanel(200);
            JScrollPane scrollPane = new JScrollPane(panel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1920, 1080);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
    }

}