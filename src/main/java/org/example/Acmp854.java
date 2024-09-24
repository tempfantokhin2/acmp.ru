package org.example;

import java.util.Scanner;

//https://acmp.ru/index.asp?main=task&id_task=854
public class Acmp854 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new File("acmp854_input.txt"));
        System.out.println("Enter input data:");
        int troom = scanner.nextInt(), tcond = scanner.nextInt();
        String mode = scanner.next();
        //System.out.println(acmp854(troom, tcond, mode));
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.setMode(mode);
        airConditioner.setTcond(tcond);
        System.out.println(airConditioner.calculateResult(troom));
    }

    public static int acmp854(int troom, int tcond, String mode) {
        if (troom < tcond && (mode.equals("heat") || mode.equals("auto"))) return tcond;
        if (troom > tcond && (mode.equals("freeze") || mode.equals("auto"))) return tcond;
        return troom;
    }
}

class AirConditioner {
    int tcond;
    String mode;

    AirConditioner() {
    }

    public int setMode(String mode) {
        if (mode.equals("heat") || mode.equals("auto")
                || mode.equals("freeze") || mode.equals("fan")){
            this.mode = mode;
            return 1;
        }
        System.out.println("Error setting mode");
        return -1;
    }
    public int setTcond(int tcond) {
        if (tcond <= 50 && tcond >= -50){
            this.tcond = tcond;
            return 1;
        }
        System.out.println("Error setting temperature target");
        return -1;
    }

    public int calculateResult(int troom) {
        if (troom < tcond && (mode.equals("heat") || mode.equals("auto"))) return tcond;
        if (troom > tcond && (mode.equals("freeze") || mode.equals("auto"))) return tcond;
        return troom;
    }
}