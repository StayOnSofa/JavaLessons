package zadanie3;

import java.util.*;

public class Program {

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
    }
}
