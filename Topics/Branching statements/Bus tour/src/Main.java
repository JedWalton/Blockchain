/*
A bus tour of Europe has been very successful. Due to an increase in the number of people who want to go on a tour, the tour company decided to increase the height of the bus. The new height of the bus is exactly N centimeters.

But the tour’s route runs under a lot of bridges, and there is a chance that the bus will crash into one of these bridges. Can you find out if this will happen?

The first line of the input contains the height of the bus and the number of bridges under which the bus passes. The second line contains the heights of these bridges.

You should output "Will not crash" if everything will be alright; otherwise, output "Will crash on bridge i" (where i is the number of the bridge) into which the bus will crash. If the height of a bridge equals the height of the bus, the bus will crash.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int busHeight = scanner.nextInt();
        int numberOfBridges = scanner.nextInt();
        boolean crash = false;
        int firstBridgeCrashedInto = 0;
        //int i=1;
        for (int i = 1; i <= numberOfBridges; i++) {
            int bridgeHeight = scanner.nextInt();
            if (bridgeHeight <= busHeight) {
                crash = true;
                if (firstBridgeCrashedInto == 0) {
                    firstBridgeCrashedInto = i;
                }
            }
        }
        if (crash) {
            System.out.print("Will crash on bridge " + firstBridgeCrashedInto);
        } else {
            System.out.print("Will not crash");
        }
    }
}