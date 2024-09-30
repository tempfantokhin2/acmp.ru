package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

record Toad(int[] coordinates, int tongueLength) {
}

class Cricket {
    private int[][] path;
    private final int travelLength;

    public Cricket(int travelLength) {
        this.travelLength = travelLength;
    }

    public void setPath(Scanner scanner) {
        this.path = new int[this.travelLength][2];
        System.out.println("Enter " + this.travelLength + " cricket coordinates:");
        for (int i = 0; i < travelLength; i++) {
            this.path[i] = new int[]{scanner.nextInt(), scanner.nextInt()};
        }
    }

    public String checkPath(Toad hungryToad) {
        int toadX = hungryToad.coordinates()[0];
        int toadY = hungryToad.coordinates()[1];

        for (int i = 0; i < travelLength; i++) {
            int x = path[i][0];
            int y = path[i][1];

            // Calculate distance between cricket and toad
            double distance = Math.sqrt(Math.pow(x - toadX, 2) + Math.pow(y - toadY, 2));

            // Check if cricket is closer than the toad's tongue length
            if (distance <= hungryToad.tongueLength()) {
                return i+1+"";
            }
        }

        return "Yes";
    }
}

class Swamp {
    private final Cricket artyom;
    private final Toad hungryToad;

    Swamp(Scanner scanner) {
        System.out.println("Enter cricket path length:");
        this.artyom = new Cricket(scanner.nextInt());
        System.out.println("Enter toad coordinate and tongue length:");
        this.hungryToad = new Toad(new int[]{scanner.nextInt(), scanner.nextInt()}, scanner.nextInt());
        this.artyom.setPath(scanner);
    }

    public String calculate() {
        return artyom.checkPath(hungryToad);
    }
}

public class Acmp986 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        try (Scanner scanner = new Scanner(new File("acmp986_input.txt"))) {
            int numberOfTests = 3;
            for (int i = 0; i < numberOfTests; i++) {

                Swamp swamp = new Swamp(scanner);

                String isCricketPathSafe = swamp.calculate();

                try (FileWriter fw = new FileWriter("output.txt", true)) {
                    fw.write(isCricketPathSafe + "\n");
                } catch (Exception e) {
                    System.err.println("Error with output.txt: " + e.getMessage());
                }

                System.out.println(isCricketPathSafe);
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}


