package model;

import java.awt.*;
import java.util.List;

public interface GameObserver {
    void updateBirdCoordinates(Point point);
    void updateTubeInfo(List<TubeInfo> tubeInfoList);

}

