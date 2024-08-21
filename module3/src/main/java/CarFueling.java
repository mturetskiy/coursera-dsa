import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int prevStopLoc = 0;
        int tankLevel = tank;
        int stopsRequired = 0;

        for (int i = 0; i < stops.length; i++) {
            int stopLoc = stops[i];

            int distance = stopLoc - prevStopLoc;
            prevStopLoc = stopLoc;

            if (distance > tank) {
                return -1;
            }

            tankLevel = tankLevel - distance;
            if (dist - stopLoc <= tankLevel) { // no need to iterate further - we are good to finish with current tank level
                return stopsRequired;
            }

            if (tankLevel == 0) {
                stopsRequired++;
                tankLevel = tank; // refuel here
            } else if (tankLevel < 0) { // consider fueling at prev stop
                stopsRequired++;
                tankLevel = tank - distance;
            } // else - try to reach next stop
        }

        if (dist - prevStopLoc > tank) {
            return -1;
        }

        if (dist - prevStopLoc > tankLevel) { // should have been fueling at last stop
            stopsRequired++;
        }

        return stopsRequired;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}