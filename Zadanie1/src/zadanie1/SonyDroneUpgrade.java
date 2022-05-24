package zadanie1;

import java.util.ArrayList;

// class 5 clone class 4
public class SonyDroneUpgrade extends SonyDrone{

    private class DroneUpgrade implements IVideoCamera
    {
        @Override
        public void TakeVideo() {
            System.out.println("Do Better Video ");
        }
    }

    private class DroneActionList extends ArrayList<String> { }
    private DroneUpgrade _upgrade;
    private DroneActionList _actionList;

    public SonyDroneUpgrade(String title, int fuel) {
        super(title, fuel);

        _upgrade = new DroneUpgrade();
        _actionList = new DroneActionList();
    }

    @Override
    public void TakeVideo()
    {
        _upgrade.TakeVideo();
        DoPrepareVideo();

        _actionList.add("Do Photo: " + _actionList.size());
    }
}
