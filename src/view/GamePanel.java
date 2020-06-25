package view;

import model.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    private Game game;

    public GamePanel() {
        game = new Game();
        Timer timer = new Timer(12, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        game.update();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        for (Render r : game.getRenders())
                g.drawImage(r.image, r.x, r.y, null);

        g2D.setColor(Color.WHITE);
        if (!game.started) {
            g2D.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g2D.drawString("Press Space to start", 150, 240);
        } else {
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 24));
            g2D.drawString(Integer.toString(game.score), 10, 465);
        }
        if (game.gameover) {
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Your score is: " + Integer.toString(game.score), 150, 240);
            g2D.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g2D.drawString("Press Enter to restart",120, 260);
        }
    }
}