/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zadanie8;

/**
 *
 * @author StayO
 */
public class OutputThread extends Thread {
    
    private int[][] array1;
    private int[][] array2;
    
    public OutputThread(int[][] array1, int[][] array2)
    {
        this.array1 = array1;
        this.array2 = array2;
    }
    
    @Override
    public void run()
    {
     System.out.println("OldArray");

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                System.out.print(array1[x][y] + " ");
            }
            
            System.out.print("\n");
        }

        System.out.println("RefactorArray");

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                System.out.print(array2[x][y] + " ");
            }
            
            System.out.print("\n");
        }
    }
    
}
