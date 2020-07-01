package model;

import java.awt.*;
import model.Tube.*;

public class TubeInfo {
     private Point coordinates;
     private Position position;

     TubeInfo(Point coordinates, Position position){
         this.coordinates = coordinates;
         this.position = position;
     }

    public Point getCoordinates() {
        return coordinates;
    }

    public Position getPosition() {
        return position;
    }

    void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    void setPosition(Position position) {
        this.position = position;
    }
}
