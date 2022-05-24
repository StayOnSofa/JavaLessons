package zadanie3;

//class 2 clone class 1
public class GoogleDrone extends BasicDrone{

    public GoogleDrone(String title, int fuel) {
        super(title, fuel);
    }

    public void TakePhoto()
    {
        System.out.println("TakePhoto");
    }
}
