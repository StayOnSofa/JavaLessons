/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zadanie8;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

/**
 *
 * @author StayO
 */
public class DataThread extends Thread {
    
    private String FilePath = "data.xml";
    private static Random random = new Random();

    public static int Random(int min, int max)
    {
        return random.nextInt(max + 1 - min) + min;
    }

    protected void WriteData(int[][] oldData, int[][] newData)
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

    protected int[][] ReadData()
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

    protected class Index
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

    protected void FillSaveRandomArray()
    {
        int[][] array = new int[5][6];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = Random(-10, 10); 
            }
        }
        
        WriteData(array, array);
    }
    
    @Override
    public void run()
    {        
        int[][] oldArray = ReadData();
        int[][] refactorArray = ReadData();

        
        new InputThread(oldArray, refactorArray).start();
    }
}
