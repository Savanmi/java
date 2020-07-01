package model;

import controller.Controller;
import view.StartWindow;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<GameObserver> observers;

    public static final int tubesDistance = 100;
    private GameTimer gameTimer;
    private Thread gameThread;
    RecordBook recordBook;

    private int tubesDist;
    private Bird bird;
    private ArrayList<Tube> tubes;
    public int score;
    public Boolean gameover;
    public Boolean started;

    public boolean isStarted(){
        return started;
    }

    public boolean isGameOver(){
        return gameover;
    }


    public Game() {
        observers = new ArrayList<>();
        started = false;
        gameover = false;
        recordBook = initRecordBook();

        score = 0;
        tubesDist = 0;

        bird = new Bird();
        tubes = new ArrayList<>();
        Controller.getInstance().setGame(this);
    }


    public void subscribeToTheGameProcess(GameObserver observer){
        observers.add(observer);
        noifySubscribersBirdInfo();
        noifySubscribersTubeInfo();
    }

    public void unsubscribeFromTheGameProcess(GameObserver observer){
        observers.remove(observer);
    }



    private void noifySubscribersBirdInfo(){
        Point currentPoint = bird.getCoordinates();
        for(GameObserver observer : observers){
            observer.updateBirdCoordinates(currentPoint);
        }
    }

    private void noifySubscribersTubeInfo(){
        List<TubeInfo> tubeInfoList = new ArrayList<>();

        for(Tube tube : tubes){
            tubeInfoList.add(tube.getTubeInfo());
        }

        for(GameObserver observer : observers){
            observer.updateTubeInfo(tubeInfoList);
        }
    }


    private RecordBook initRecordBook() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/recordBook.out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (RecordBook) objectInputStream.readObject();

            /// Доработать закрытие файлов
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new RecordBook();
        }
    }

    private void saveRecordBook(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("src/recordBook.out");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(recordBook);
            objectOutputStream.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public RecordBook getRecordBook() {
        return recordBook;
    }

    public void startGame(){
        if (!started) {
            started = true;
            gameTimer = new GameTimer(this);
            gameThread = new Thread(gameTimer);
            gameThread.start();
        }
    }

    public void restart(){
        score = 0;
        tubesDist = 0;
        bird = new Bird();
        tubes = new ArrayList<>();
        gameover = false;
    }

    void endGame(){
        if(!gameover) {
            recordBook.addNewRecord(score);
        }
        gameover = true;
        bird.dead = true;
        saveRecordBook();
    }




    public void jump(){
        bird.jump();
    }

    public void update() {
        bird.update();
        if (gameover) {
            return;
        }
        moveTubes();
        noifySubscribersTubeInfo();
        noifySubscribersBirdInfo();
        checkForCollisions();
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
            if (t.collides(bird.x, bird.y, bird.width, bird.height )
                    || (bird.y + bird.height > StartWindow.HEIGHT - 80)) {
                endGame();
            } else if (t.x == bird.x && t.orientation.equals("ВЕРХ")) {
                score++;
            }
        }

    }
}
