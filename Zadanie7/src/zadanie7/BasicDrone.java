package zadanie7;

//class 1
public class BasicDrone {
    private String _title;
    private int _maxFuel;
    private int _fuel;

    public BasicDrone(String title, int fuel)
    {
        _maxFuel = fuel;
        _title = title;

        _fuel = _maxFuel;
    }

    public void SetTitle(String title)
    {
        _title = title;
    }

    public String GetTitle()
    {
        return _title;
    }

    public void Fly()
    {
        if (_fuel > 0)
        {
            _fuel -=1;
            System.out.println("Flying");
        }
        else
        {
            System.out.println("OutFlying");
        }
    }

    @Override
    public String toString()
    {
        return _title + " : " + -_maxFuel;
    }

}
