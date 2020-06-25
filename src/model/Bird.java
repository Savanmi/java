package model;

import controller.Controller;
import view.ImageCache;
import view.Render;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Bird {
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean dead;
    public double jumpHeight;
    public double gravity;
    private Image image;
    private Controller keyboard;

    public Bird() {
        x = 100;
        y = 150;
        jumpHeight = 0;
        width = 45;
        height = 32;
        gravity = 0.5;
        dead = false;
        keyboard = Controller.getInstance();
    }

    public void update() {
        jumpHeight += gravity;

        if (!dead && keyboard.pressed(KeyEvent.VK_SPACE) ) {
            jumpHeight = -10;
        }
        y += (int) jumpHeight;
    }

    public Render getRender() {
        Render r = new Render();
        r.x = x;
        r.y = y;

        if (image == null) {
            image = ImageCache.loadImage("C:\\Users\\Анастасия\\BIRD\\src\\images\\ПТИЦА.png");
        }
        r.image = image;
        return r;
    }
}