package Filosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private Semaphore hashi1;
    private Semaphore hashi2;
    private Semaphore hashi3;
    private Semaphore hashi4;
    private Semaphore hashi5;

    private static final int numberPhilosofers = 5;

    public Philosopher (Semaphore hashi1, Semaphore hashi2, Semaphore hashi3, Semaphore hashi4, Semaphore hashi5) {
        this.hashi1 = hashi1;
        this.hashi2 = hashi2;
        this.hashi3 = hashi3;
        this.hashi4 = hashi4;
        this.hashi5 = hashi5;
    }

    private void think() {
        try {
            System.out.println("I am thinking!");
            Thread.sleep(2500);
            System.out.println("Still thinking...");
            Thread.sleep(2500);
            System.out.println("I thought!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        try {
            System.out.println("I am eating!");
            Thread.sleep(1000);
            System.out.println("Still eating...");
            Thread.sleep(1000);
            System.out.println("I ate!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tryingToEat(){
        Random random = new Random();
        int randomTime = 0;
        long randomSplitedTime = 0;

        randomTime = random.nextInt(3);
        randomSplitedTime = randomTime/2;

        try {
            System.out.println("I trying to eat!");
            Thread.sleep(randomSplitedTime);
            System.out.println("Still trying...");
            Thread.sleep(randomSplitedTime);
            System.out.println("Tried to :c");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeHashi(int n) {

    }

    @Override
    public void run() {
        Random random = new Random();
        int hashi = random.nextInt(numberPhilosofers);

        while (true){

            think();
            takeHashi(hashi);
        }
    }
}
