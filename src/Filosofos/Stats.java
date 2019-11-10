package Filosofos;

public class Stats {
    private String name;
    private int timesAte = 0;
    private int timesTriedEat = 0;
    private int timesThought = 0;

    public Stats(String name) {
        this.name = name;
    }

    public Stats() {

    }

    public void sumTimesAte(){
        timesAte++;
    }

    public void sumTimesTriedEating(){
        timesTriedEat++;
    }

    public void sumTimesThought(){
        timesThought++;
    }

    public void actionsReport(){
        System.out.println("=========================");
        System.out.println("| " + this.name + " ate " + timesAte + " times" + " |");
        System.out.println("| " + this.name + " tried to eat " + timesTriedEat + " times" + " |");
        System.out.println("| " + this.name + " thought " + timesThought+ " times" + " |");
        System.out.println("=========================");
    }

    public int getTimesAte() {
        return timesAte;
    }

    public int getTimesTriedEat() {
        return timesTriedEat;
    }

    public int getTimesThought() {
        return timesThought;
    }

    public String getName() {
        return name;
    }
}
