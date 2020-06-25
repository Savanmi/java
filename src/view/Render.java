package view;

import java.awt.Image;

public class Render {
    public int x;
    public int y;
    public Image image;
    public Render() {
    }

    public Render(int x, int y, String imagePath) {
        this.x = x;
        this.y = y;
        this.image = ImageCache.loadImage(imagePath);
    }
}