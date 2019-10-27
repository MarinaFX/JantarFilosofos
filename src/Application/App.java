package Application;

import Filosofos.Philosopher;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class App {
    private static final int MAX_THREADS = 1;
    private static final Semaphore hashi1 = new Semaphore(MAX_THREADS, true);
    private static final Semaphore hashi2 = new Semaphore(MAX_THREADS, true);
    private static final Semaphore hashi3 = new Semaphore(MAX_THREADS, true);
    private static final Semaphore hashi4 = new Semaphore(MAX_THREADS, true);
    private static final Semaphore hashi5 = new Semaphore(MAX_THREADS, true);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Thread philosopher1 = new Thread(new Philosopher(hashi1, hashi2, hashi3, hashi4, hashi5));
        Thread philosopher2 = new Thread(new Philosopher(hashi1, hashi2, hashi3, hashi4, hashi5));

        /*Thread philosopher3 = new Thread(new Philosopher(hashi1, hashi2, hashi3, hashi4, hashi5));
        Thread philosopher4 = new Thread(new Philosopher(hashi1, hashi2, hashi3, hashi4, hashi5));
        Thread philosopher5 = new Thread(new Philosopher(hashi1, hashi2, hashi3, hashi4, hashi5));
        */

        System.out.println("Olá, bem vindo ao jantar dos filosofos");
        System.out.println("Quantos filosofos você deseja na mesa?");
        int numberPhilosofer = in.nextInt();
        System.out.println("Ótimo! e por quanto tempo esse jantar deve durar?");
        System.out.println("Insira o tempo em segundos por favor. Ex: 240 (4 minutos)");
        long dinnerTime = in.nextInt();


        philosopher1.start();
        philosopher2.start();

        try {
            Thread.sleep(dinnerTime);
            philosopher1.join();
            philosopher2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
