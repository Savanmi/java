package view;

import controller.Controller;

import javax.swing.*;

public class StartWindow {

    public static int WIDTH = 500;
    public static int HEIGHT = 520;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Controller controller = Controller.getInstance();
        frame.addKeyListener(controller);

        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
    }
}
