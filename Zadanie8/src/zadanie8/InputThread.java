package zadanie8;

/**
 *
 * @author StayO
 */
public class InputThread extends DataThread{
    
    private int[][] array1;
    private int[][] array2;
    
    public InputThread(int[][] array1, int[][] array2)
    {
        this.array1 = array1;
        this.array2 = array2;
    }
    
    @Override
    public void run()
    {
    int sum = 0;

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                sum += array1[x][y];
            }
        }
        
        System.out.println("Sum" + " " + sum);

        if (sum > 100)
        {
            Index minimum = getIndexOfMinimum(array2);
            Index maximum = getIndexOfMaximum(array2);

            int minValue = array2[minimum.X][minimum.Y];
            int maxValue = array2[maximum.X][maximum.Y];

            array2[minimum.X][minimum.Y] = maxValue;
            array2[maximum.X][maximum.Y] = minValue;
        }
        
        WriteData(array1, array2);
        
        new OutputThread(array1, array2).start();
    }
    
}
