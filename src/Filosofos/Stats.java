package Filosofos;

public class Stats {
    private String name;
    private int timesAte = 0;
    private int timesTriedEat = 0;
    private int timesThought = 0;

    public void setName(String name) {
        this.name = name;
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
        System.out.println("====================================");
        System.out.println("| " + name + " ate " + timesAte + " times" + "           |");
        System.out.println("| " + name + " tried to eat " + timesTriedEat + " times" + "  |");
        System.out.println("| " + name + " thought " + timesThought+ " times" + "       |");
        System.out.println("====================================");
    }

    public String getName() {
        return name;
    }
}
