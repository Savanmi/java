package view;

import model.Game;
import model.RecordBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    private Game game;
    private RecordBook recordBook;
    private GameElements gameElements;


    GamePanel() {
        game = new Game();
        Timer timer = new Timer(10, this);
        timer.start();
        recordBook = game.getRecordBook();

        gameElements = new GameElements();
        game.subscribeToTheGameProcess(gameElements);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        if(game.isStarted()) {
            gameElements.paintComponents(g, this);
        }

        g2D.setColor(Color.WHITE);
        if (!game.started) {
            g2D.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g2D.drawString("Press Space to start", 150, 240);
        } else {
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 26));
            g2D.drawString(Integer.toString(game.score), 10, 465);
        }
        if (game.gameover) {
            g2D.drawString("Press Enter to restart",150, 180);
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("Your score is: " + game.score, 175, 240);

            int numberOfRecords = (recordBook.getNumberOfRecords() < 3) ? recordBook.getNumberOfRecords() : 3;
            g2D.drawString("Best records: ", 175, 280);
            for(int i = 0; i < numberOfRecords; i++){
                g2D.drawString((i + 1) + " place:  " + recordBook.getRecord(i) + " tube(s)", 175, 300 + (i * 20));
            }
        }

    }
}
