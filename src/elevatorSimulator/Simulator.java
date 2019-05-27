package elevatorSimulator;

import java.util.*;

public class Simulator {
    protected static final int MAX_PEOPLE = 20; //TODO: all of people
    private static volatile int counter;
    private static PoissonDis poissonDis;
    protected static Time time = new Time();
    protected static int flag = 0;
    protected static int peopleflag = 0;
    protected static int timestate = 1000;

    public static void main(String[] args) throws InterruptedException {

        String source = null;
        if (args.length > 0)
            source = args[0];
        ElevatorConsole console = new ElevatorConsole(source);
        poissonDis = new PoissonDis();
        Vector people = new Vector();
        Building b = new Building();
        console.setBuilding(b);
        Person.setBuilding(b);
        time.start();

        int val;

        for (counter = 0; ; counter++) {
            console.updateDisplay();
            if (peopleflag == 0) {
                if (Time.getHours() >= 6 && Time.getHours() < 8) {
                    val = poissonDis.PoissonRandom(2);
                    for (int i = 0; i < val; i++) {
                        Person p = new Person(i + 1);
                        people.add(p);
                        p.start();
                    }
                } else if (Time.getHours() >= 8 && Time.getHours() <= 15) {
                    if ((Math.random() * 5) > 3) {
                        val = poissonDis.PoissonRandom(1);
                        for (int i = 0; i < val; i++) {
                            Person p = new Person(i + 1);
                            people.add(p);
                            p.start();
                        }
                    }
                }
                peopleflag = 5;
            }
            peopleflag--;
            Thread.currentThread().sleep(timestate);
        }
    }
}


