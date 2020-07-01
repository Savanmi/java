package model;


import java.awt.*;

class Bird {
    int x;
    int y;
    int width;
    int height;
    boolean dead;
    private double jumpHeight;
    private double gravity;
    private Image image;

    private int jumpingStack;

    Bird() {
        jumpingStack = 0;
        x = 100;
        y = 150;
        jumpHeight = 0;
        width = 45;
        height = 32;
        gravity = 0.5;
        dead = false;
    }


    void jump(){
        jumpingStack += 4;
    }

    void update() {
        jumpHeight += gravity;

        if (!dead && jumpingStack != 0) {
            jumpingStack--;
            jumpHeight = -10;
        }
        y += (int) jumpHeight;
    }

    Point getCoordinates() {
        return new Point(x, y);
    }
}
