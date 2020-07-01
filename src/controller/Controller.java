package controller;

import model.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private static Controller controller;
    private Game game;

    public void setGame(Game game){
        this.game = game;
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(!game.started) {
                game.startGame();
            }

            game.jump();
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(game.gameover) {
                game.restart();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
