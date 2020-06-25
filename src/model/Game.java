package model;

import controller.Controller;
import view.StartWindow;
import view.Render;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {

    public static final int tubesDistance = 100;

    private int tubesDist;
    private Bird bird;
    private ArrayList<Tube> tubes;
    private Controller keyboard;
    public int score;
    public Boolean gameover;
    public Boolean started;

    public Game() {
        keyboard = Controller.getInstance();
        restart();
    }

    public void update() {
        isStarted();
        if (!started) {
            return;
        }
        isRestarted();
        bird.update();
        if (gameover) {
            return;
        }
        moveTubes();
        checkForCollisions();
    }

    public void restart() {
        started = false;
        gameover = false;

        score = 0;
        tubesDist = 0;

        bird = new Bird();
        tubes = new ArrayList<Tube>();
    }

    private void isStarted() {
    if (!started && keyboard.pressed(KeyEvent.VK_SPACE)) {
            started = true;
       }
    }

    private void isRestarted() {
        if (keyboard.pressed(KeyEvent.VK_ENTER) ) {
            restart();
        }
    }

    public ArrayList<Render> getRenders() {
        ArrayList<Render> renders = new ArrayList<Render>();
        renders.add(new Render(0, 0, "C:\\Users\\Анастасия\\BIRD\\src\\images\\ФОН.png"));
        for (Tube t : tubes)
            renders.add(t.getRender());
        renders.add(new Render(0, 0, "C:\\Users\\Анастасия\\BIRD\\src\\images\\ЗЕМЛЯ.png"));
        renders.add(bird.getRender());
        return renders;
    }

    private void moveTubes() {
        tubesDist--;

        if (tubesDist < 0) {
            tubesDist = tubesDistance;
            Tube bottomTube = null;
            Tube topTube = null;

            if (bottomTube == null) {
                Tube tube = new Tube("НИЗ");
                tubes.add(tube);
                bottomTube = tube;
            } else {
                bottomTube.reset();
            }

            if (topTube == null) {
                Tube tube = new Tube("ВЕРХ");
                tubes.add(tube);
                topTube = tube;
            } else {
                topTube.reset();
            }
            bottomTube.y = topTube.y + topTube.height + 180;
        }
        for (Tube t : tubes) {
            t.update();
        }
    }

    private void checkForCollisions() {

        for (Tube t : tubes) {
            if (t.collides(bird.x, bird.y, bird.width, bird.height ) || bird.y + bird.height > StartWindow.HEIGHT - 80) {
                gameover = true;
                bird.dead = true;
            } else if (t.x == bird.x && t.orientation.equals("ВЕРХ")) {
                score++;
            }
        }

    }
}