package model;

import java.awt.*;

import view.StartWindow;
//import view.ImageCache;
//import view.Render;

public class Tube {

    public enum Position{
        TOP,
        BOTTOM
    }

    int x;
    int y;
    int width;
    int height;
    int speed = 3;
    String orientation;
    private Image image;

    Tube(String orientation) {
        this.orientation = orientation;
        reset();
    }

    void reset() {
        width = 66;
        height = 400;
        x = StartWindow.WIDTH + 2;

        if (orientation.equals("ВЕРХ")) {
            y = -(int)(Math.random() * 120) - height / 2;
        }
    }

    void update() {
        x -= speed;
    }

    boolean collides(int bx, int by, int bWidth, int bHeight) {
        if (bx + bWidth  > x && bx < x + width) {
            if (orientation.equals("ВЕРХ") && by < y + height) {
                return true;
            } else if (orientation.equals("НИЗ") && by + bHeight > y) {
                return true;
            }
        }
        return false;
    }

    TubeInfo getTubeInfo(){
        Point coordinates = new Point(x, y);
        Position position = (orientation.equals("ВЕРХ")) ? Position.TOP : Position.BOTTOM;
        return new TubeInfo(coordinates, position);
    }
}
