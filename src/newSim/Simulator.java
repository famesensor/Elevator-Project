package newSim;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Simulator {
    public static volatile boolean debug = false;
    public static final int MAX_PEOPLE = 20; //TODO: all of people
    public static int OUTTIME = 7;
    private static volatile int counter;
    private static PoissonDis poissonDis;
    public static int getElapsedTime(){
        return counter/2;
    }
    public static Time time = new Time();
    protected static int flag = 0;
    private static int peopleflag = 0;
    protected static int timestate = 1000;
    public static void main(String[] args) throws InterruptedException {

        String source = null;
        if(args.length >0)
            source = args[0];
        ElevatorConsole console = new ElevatorConsole(source);
        poissonDis = new PoissonDis();
        Vector people = new Vector();
        Building b = new Building();
        console.setBuilding(b);
        Person.setBuilding(b);
        time.start();

        int val;
//        for(int i = 0; i < MAX_PEOPLE; i++){
//            Person p = new Person(i+1);
//            people.add(p);
//            p.start();
//        }
        for(counter = 0; ; counter++){
            console.updateDisplay();
//            System.out.println("Time : "+Time.getHours());
            if(peopleflag == 0){
                if(Time.getHours() >= 6 && Time.getHours() <8){
                    val = poissonDis.PoissonRandom(2);
                    System.out.println("VAL : "+val);
                    for (int i = 0; i < val; i++){
                        Person p = new Person(i+1);
                        people.add(p);
                        p.start();
//                    TimeUnit.SECONDS.sleep(1);
                    }
//                    Thread.currentThread().sleep(timestate);
                } else if (Time.getHours() >= 8 && Time.getHours() <= 15) {
                    if ((Math.random() * 5) > 3) {
                        val = poissonDis.PoissonRandom(1);
                        System.out.println("VAL2 : " + val);
                        for (int i = 0; i < val; i++) {
                            Person p = new Person(i + 1);
                            people.add(p);
                            p.start();
                        }
                    }
//                    Thread.currentThread().sleep(timestate);
                }
                peopleflag = 5;
            }
            peopleflag--;
            Thread.currentThread().sleep(timestate);

//            if(Time.getHours() >= 6 && Time.getHours() <8){
//                val = poissonDis.PoissonRandom(2);
//                System.out.println("VAL : "+val);
//                for (int i = 0; i < val; i++){
//                    Person p = new Person(i+1);
//                    people.add(p);
//                    p.start();
////                    TimeUnit.SECONDS.sleep(1);
//                }
//                Thread.currentThread().sleep(timestate);
//            } else if (Time.getHours() >= 8 && Time.getHours() <= 15) {
//                if ((Math.random() * 5) > 3) {
//                    val = poissonDis.PoissonRandom(1);
//                    System.out.println("VAL2 : " + val);
//                    for (int i = 0; i < val; i++) {
//                        Person p = new Person(i + 1);
//                        people.add(p);
//                        p.start();
//                    }
//                }
//                Thread.currentThread().sleep(timestate);
//            }else{
//                Thread.currentThread().sleep(timestate);
//            }
//            try{
//                Thread.currentThread().sleep(500);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            if(Time.getHours() == 7){
//                for(int i = 0; i < people.size(); i++){
//                    ((Person)people.get(i)).setStopRunning();
//                }
//            }
        }

//        for(int i = 0; i < people.size(); i++){
//            ((Person)people.get(i)).setStopRunning();
//        }
    }

}


