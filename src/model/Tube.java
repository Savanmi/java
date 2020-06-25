package model;

import java.awt.Image;
import view.StartWindow;
import view.ImageCache;
import view.Render;

public class Tube {

    public int x;
    public int y;
    public int width;
    public int height;
    public int speed = 3;
    public String orientation;
    private Image image;

    public Tube(String orientation) {
        this.orientation = orientation;
        reset();
    }

    public void reset() {
        width = 66;
        height = 400;
        x = StartWindow.WIDTH + 2;

        if (orientation.equals("ВЕРХ")) {
            y = -(int)(Math.random() * 120) - height / 2;
        }
    }

    public void update() {
        x -= speed;
    }

    public boolean collides(int bx, int by, int bWidth, int bHeight) {
        if (bx + bWidth  > x && bx < x + width) {
            if (orientation.equals("ВЕРХ") && by < y + height) {
                return true;
            } else if (orientation.equals("НИЗ") && by + bHeight > y) {
                return true;
            }
        }
        return false;
    }

    public Render getRender() {
        Render r = new Render();
        r.x = x;
        r.y = y;
        if (image == null) {
            image = ImageCache.loadImage("C:\\Users\\Анастасия\\BIRD\\src\\images\\ТРУБА-" + orientation + ".png");
        }
        r.image = image;
        return r;
    }
}