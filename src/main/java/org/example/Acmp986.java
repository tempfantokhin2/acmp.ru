package org.example;

import java.util.Scanner;

class Toad {
    int tongueLength;
    int[] coordinates;

    public Toad(int[] coordinates, int tongueLength) {
        this.tongueLength = tongueLength;
        this.coordinates = coordinates;
    }

    public int getTongueLength() {
        return tongueLength;
    }

    public int[] getCoordinates() {
        return coordinates;
    }
}

class Cricket {
    int[][] path;
    int travelLength;

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

    public int checkPath(Toad hungryToad) {
        int toadX = hungryToad.getCoordinates()[0];
        int toadY = hungryToad.getCoordinates()[1];

        for (int i = 0; i < travelLength; i++) {
            int x = path[i][0];
            int y = path[i][1];

            // Calculate distance between cricket and toad
            double distance = Math.sqrt(Math.pow(x - toadX, 2) + Math.pow(y - toadY, 2));

            // Check if cricket is closer than the toad's tongue length
            if (distance <= hungryToad.getTongueLength()) {
                System.out.println(i+1);
                return i+1;
            }
        }

        System.out.println("Yes");
        return -1;
    }
}

class Swamp {
    Cricket artyom;
    Toad hungryToad;

    Swamp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cricket path length:");
        this.artyom = new Cricket(scanner.nextInt());
        System.out.println("Enter toad coordinate and tongue length:");
        this.hungryToad = new Toad(new int[]{scanner.nextInt(), scanner.nextInt()}, scanner.nextInt());
        this.artyom.setPath(scanner);
    }

    public void calculate() {
        artyom.checkPath(hungryToad);
    }
}

public class Acmp986 {
    public static void main(String[] args) {
        Swamp swamp = new Swamp();
        swamp.calculate();
    }
}


