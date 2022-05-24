package zadanie7;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    private void WriteDronesToXML(ArrayList<SonyDrone> drones)
    {
        XMLEncoder encoder;
        try {
            encoder = new XMLEncoder(
                    new BufferedOutputStream(new FileOutputStream("Drones.xml"))
            );
            
             encoder.writeObject(drones.size());
            
            for (int i = 0; i < drones.size(); i++)
            {
                SonyDrone drone = drones.get(i);

                String write = drone.GetTitle();
                encoder.writeObject(write);
            }

            encoder.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<SonyDrone> RestoreDronesFormXML()
    {
        ArrayList<SonyDrone> drones = new ArrayList<>();

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Drones.xml")));

            int size = (int)decoder.readObject();
            
            for (int i = 0; i < size; i++)
            {
                String title = (String) decoder.readObject();

                SonyDrone sonyDrone = new SonyDrone("Drones", 10);
                sonyDrone.SetTitle(title);

                drones.add(sonyDrone);
            }

            decoder.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }

        return drones;
    }
    
    
    public void Run(int N)
    {
        ArrayList<SonyDrone> dronesList = new ArrayList<>();
        HashSet<SonyDrone> dronesHashSet = new HashSet<>();
        HashMap<SonyDrone, String> dronesHash = new HashMap<>();

        for (int i = 0; i < N; i++)
        {
            String title = "SonyDrone: " + i;
            SonyDrone drone = new SonyDrone(title, 10);

            dronesList.add(drone);
            dronesHash.put(drone, title);
            dronesHashSet.add(drone);

            System.out.println(title + " created");
        }

        SonyDrone droneToDelete = dronesList.get(0);
        dronesHashSet.remove(droneToDelete);
        dronesHash.remove(droneToDelete);

        dronesList.remove(droneToDelete);

        int index = 0;
        SonyDrone lastDrone = null;

        for(Map.Entry<SonyDrone, String> entry : dronesHash.entrySet()) {

            SonyDrone key = entry.getKey();

            if (index == dronesHash.size() - 1)
            {
                lastDrone = key;
            }

            index +=1;

        }

        lastDrone.SetTitle("Changed");
        dronesList.get(dronesList.size()-1).SetTitle("Changed");

        //iterate map
        for(Map.Entry<SonyDrone, String> entry : dronesHash.entrySet()) {

            SonyDrone key = entry.getKey();
            System.out.println("DroneKey in HashMap: " + key.GetTitle());
        }

        //iterate list
        for (int i = 0; i < dronesList.size(); i++)
        {
            SonyDrone drone = dronesList.get(i);
            System.out.println("DroneKey in List: " + drone.GetTitle());
        }

        //iterate set
        for (SonyDrone drone : dronesHashSet) {
            System.out.println("DroneKey in Set: " + drone.GetTitle());
        }
        
        //Save Drones List to XML
        WriteDronesToXML(dronesList);
        
        //Restore Drones From XML
        dronesList = RestoreDronesFormXML();
    }
}
