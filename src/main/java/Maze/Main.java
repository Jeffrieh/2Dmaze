package Maze;

import java.util.Stack;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Main extends Canvas{

    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Main();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
}
