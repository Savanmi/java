package model;

public class GameTimer implements Runnable {
    private Game game;

    GameTimer(Game game){
        this.game = game;
    }

//    private long claculateDelay(){
//        /// === ///
//    }


    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {
            game.update();



//            timeDiff = System.currentTimeMillis() - beforeTime;
//            sleep = claculateDelay() - timeDiff;


            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());

            }

//            beforeTime = System.currentTimeMillis();
        }
    }
}

