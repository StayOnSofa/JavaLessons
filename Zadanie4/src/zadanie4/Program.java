package zadanie4;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Random;


//Load data from .xml file
public class Program {

    private String FilePath = "data.xml";
    private static Random random = new Random();

    public static int Random(int min, int max)
    {
        return random.nextInt(max + 1 - min) + min;
    }

    private void WriteData(int[][] oldData, int[][] newData)
    {
        try {
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(new FileOutputStream(FilePath))
            );

            encoder.writeObject( oldData);
            encoder.writeObject( newData);

            encoder.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] ReadData()
    {
        int[][] array = null;

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FilePath)));
            array = (int[][]) decoder.readObject();
            decoder.readObject();

            decoder.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return array;
    }

    private class Index
    {
        public int X;
        public int Y;

        public Index(int x, int y)
        {
            X = x;
            Y = y;
        }
    }

    public Index getIndexOfMinimum( int[][] array )
    {
        int mX = 0;
        int mY = 0;

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if (array[x][y] < array[mX][mY])
                {
                    mX = x;
                    mY = y;
                }
            }
        }

        return new Index(mX, mY);
    }

    public Index getIndexOfMaximum( int[][] array )
    {
        int mX = 0;
        int mY = 0;

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                if (array[x][y] > array[mX][mY])
                {
                    mX = x;
                    mY = y;
                }
            }
        }

        return new Index(mX, mY);
    }

    private void FillSaveRondomArray()
    {
        int[][] array = new int[5][6];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = Random(-10, 10); 
            }
        }
        
        WriteData(array, array);
    }
    
    
    //2. Swap large and include table elements if number of table values greater
    public void Run()
    {
        //FillSaveRondomArray();
        
        int[][] oldArray = ReadData();
        int[][] refactorArray = ReadData();

        int sum = 0;

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                sum += oldArray[x][y];
            }
        }
        
         System.out.println("Sum" + " " + sum);

        if (sum > 100)
        {
            Index minimum = getIndexOfMinimum(refactorArray);
            Index maximum = getIndexOfMaximum(refactorArray);

            int minValue = refactorArray[minimum.X][minimum.Y];
            int maxValue = refactorArray[maximum.X][maximum.Y];

            refactorArray[minimum.X][minimum.Y] = maxValue;
            refactorArray[maximum.X][maximum.Y] = minValue;
        }
        
        WriteData(oldArray, refactorArray);

        System.out.println("OldArray");

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                System.out.print(oldArray[x][y] + " ");
            }
            
            System.out.print("\n");
        }

        System.out.println("RefactorArray");

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                System.out.print(refactorArray[x][y] + " ");
            }
            
            System.out.print("\n");
        }
    }

}
