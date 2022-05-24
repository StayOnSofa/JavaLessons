package zadanie3;

//class 3 clone class 2 with interface
public abstract class VideoCameraDrone extends GoogleDrone implements IVideoCamera {
    private int _maxMemory = 2;
    private int _memory = 0;

    public VideoCameraDrone(String title, int fuel) {
        super(title, fuel);

        _memory = _maxMemory;
    }

    public boolean HasMemory()
    {
        return _memory > 0;
    }

    public abstract void DoPrepareVideo();

    @Override
    public void TakeVideo() {
        if (_memory > 0) {
            System.out.println("Take Video");
                DoPrepareVideo();

            _memory--;
        }
        else{
            System.out.println("Is Memory Full");
        }
    }
}
