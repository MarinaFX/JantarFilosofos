package Application;

import Filosofos.Philosopher;
import Filosofos.Stats;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class App {
    private static final int MAX_THREADS = 1;

    private static Semaphore forks[];
    private static Thread philosofers[];
    private static Stats stats[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Olá, bem vindo ao jantar dos filosofos");
        System.out.println("Quantos filosofos você deseja na mesa?");
        int numberPhilosofers = in.nextInt();

        while(numberPhilosofers<=1) {
            System.out.println("Número de filósofos inválido.");
            System.out.println("Quantos filosofos você deseja na mesa?");
            numberPhilosofers = in.nextInt();
        }

        System.out.println("Ótimo! e por quanto tempo esse jantar deve durar?");
        System.out.println("Insira o tempo em segundos por favor. Ex: 240 (4 minutos)");
        long dinnerTime = in.nextLong();

        while(dinnerTime<=0) {
            System.out.println("Tempo inválido");
            System.out.println("Insira o tempo em segundos por favor. Ex: 240 (4 minutos)");
            dinnerTime = in.nextLong();
        }

        forks = new Semaphore[numberPhilosofers];
        philosofers = new Thread[numberPhilosofers];
        stats = new Stats[numberPhilosofers];

        for (int i = 0 ; i < forks.length ; i++){
            forks[i] = new Semaphore(MAX_THREADS, true);
        }

        for (int i = 0 ; i < forks.length ; i++){
            stats[i] = new Stats();
            philosofers[i] = new Thread(new Philosopher(forks, numberPhilosofers, "Filósofo " + (i+1), stats[i], dinnerTime));
        }

        for (int i = 0 ; i < forks.length ; i++){
            philosofers[i].start();
        }

        try {
            for (int i = 0 ; i < forks.length ; i++){
                philosofers[i].join();
            }
            for(int i=0; i< forks.length; i++) {
                stats[i].actionsReport();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
