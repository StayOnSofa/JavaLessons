package zadanie2;
/**
 *
 * @author StayO
 */
public class Zadanie1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                //Z 1

        BasicDrone basicDrone = new BasicDrone("BasicDroen", 10);
        basicDrone.Fly();

        GoogleDrone googleDrone = new GoogleDrone("GoogleDrone", 10);
        googleDrone.Fly();
        googleDrone.TakePhoto();

        SonyDrone sonyDrone = new SonyDrone("SonyDrone", 10);
        sonyDrone.Fly();
        sonyDrone.TakePhoto();

        IVideoCamera videoCamera = sonyDrone;
        videoCamera.TakeVideo();

        //Z 2
        Program program = new Program();
        program.Run(18);
    }
    
}
