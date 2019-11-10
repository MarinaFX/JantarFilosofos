package Filosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private Stats stats;
    private Semaphore forks[];
    private long dinnerTime = 0;

    private static int numberPhilosofers;

    public Philosopher (Semaphore forks[], int numberPhilosofers, String name, Stats stats, long dinnerTime) {
        this.forks = forks;
        Philosopher.numberPhilosofers = numberPhilosofers;
        this.dinnerTime = dinnerTime;
        this.stats = stats;
        this.stats = new Stats(name);
    }

    private void think() {
        try {
            System.out.println(stats.getName() + " is thinking!");
            Thread.sleep(2500);
            System.out.println(stats.getName() + " still thinking...");
            Thread.sleep(2500);
            System.out.println(stats.getName() + " thought!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stats.sumTimesThought();
    }

    private void eat() {
        try {
            System.out.println(stats.getName() + " is eating!");
            Thread.sleep(1000);
            System.out.println(stats.getName() + " still eating...");
            Thread.sleep(1000);
            System.out.println(stats.getName() + " ate!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stats.sumTimesAte();
    }

    private void tryingToEat(int fork){
        Random random = new Random();
        int randomTime = 0;
        int time = 0;

        randomTime = random.nextInt(3);

        try {
            while (time < randomTime){
                System.out.println(stats.getName() + " will try to eat!");
                if (forks[(fork+1) % numberPhilosofers].tryAcquire()){
                    forks[(fork+1) % numberPhilosofers].release();
                    forks[(fork+1) % numberPhilosofers].acquire();
                    eat();
                    forks[(fork+1) % numberPhilosofers].release();
                    break;
                }
                else {
                    System.out.println(stats.getName() + " still trying...");
                    time++;
                }

                if (time == randomTime)
                    System.out.println(stats.getName() + " could not eat :c");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stats.sumTimesTriedEating();
    }

    private void takeFork(int fork) {
        if (forks[fork].tryAcquire()){
            forks[fork].release();
            try {
                forks[fork].acquire();
                tryingToEat(fork);
                forks[fork].release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        int fork = random.nextInt(numberPhilosofers);

        while (true){
            think();
            takeFork(fork);
        }
    }
}
