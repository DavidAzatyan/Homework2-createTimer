package com.company;

import java.util.Scanner;

public class Timer {

    static int minutes;
    static int seconds;
    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                while (minutes >= 0) {
                    Thread.sleep(1000);
                    System.out.println(minutes + " : " + seconds);
                    seconds--;
                    if (seconds == 0) {
                        minutes = minutes - 1;
                        seconds = 59;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input minutes ");
        minutes = scanner.nextInt();
        System.out.print("Input seconds ");
        seconds = scanner.nextInt();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
