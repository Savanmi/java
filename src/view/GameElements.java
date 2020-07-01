package view;

import model.GameObserver;
import model.Tube.Position;
import model.TubeInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.List;

public class GameElements implements GameObserver {

    private List<TubeInfo> tubeInfoList;
    private Point birdPoint;

    private Image tubeTopImage;
    private Image tubeBottomImage;
    private Image birdImage;
    private Image background;
    private Image ground;

    GameElements(){
        birdImage = extractImage("src/images/ПТИЦА.png");
        tubeTopImage = extractImage("src/images/ТРУБА-ВЕРХ.png");
        tubeBottomImage = extractImage("src/images/ТРУБА-НИЗ.png");
        background = extractImage("src/images/ФОН.png");
        ground = extractImage("src/images/ЗЕМЛЯ.png");
    }

    private Image extractImage(String imageName){
        ImageIcon imageIcon = new ImageIcon(imageName);
        return imageIcon.getImage();
    }


    @Override
    public void updateBirdCoordinates(Point point) {
        birdPoint = point;
    }

    @Override
    public void updateTubeInfo(List<TubeInfo> tubeInfoList) {
        this.tubeInfoList = tubeInfoList;
    }
 
    void paintComponents(Graphics g, ImageObserver imageObserver){
            g.drawImage(background, 0, 0, imageObserver);
            for(TubeInfo tube : tubeInfoList){
                if(tube.getPosition() == Position.TOP){
                    g.drawImage(tubeTopImage, tube.getCoordinates().x, tube.getCoordinates().y, imageObserver);
                } else{
                    g.drawImage(tubeBottomImage, tube.getCoordinates().x, tube.getCoordinates().y, imageObserver);
                    g.drawImage(ground, 0, 0, imageObserver);
                }
            }
        g.drawImage(birdImage, birdPoint.x, birdPoint.y, imageObserver);

    }


}
