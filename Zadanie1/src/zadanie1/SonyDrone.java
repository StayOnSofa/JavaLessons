package zadanie1;

//class 4 clone class 3 with implement abstract method
public class SonyDrone extends VideoCameraDrone {
    public SonyDrone(String title, int fuel) {
        super(title, fuel);
    }

    @Override
    public void DoPrepareVideo() {
        System.out.println("Do SFX");
    }
}
