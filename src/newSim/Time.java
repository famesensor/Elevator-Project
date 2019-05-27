package newSim;

import java.util.Timer;
import java.util.TimerTask;

public class Time implements Runnable {
    private static int minutes = 0;
    private static int hours = 6;
    private static String time_run;
    private Thread thread;

    public Time(){
        thread = new Thread(this);
    }

    public void start(){
        thread.start();
    }

    protected static int getMinutes(){
        return minutes;
    }

    protected static int getHours(){
        return hours;
    }

    protected static String getTime_run() {
        return time_run;
    }

    private static void timerTick() {
        minutes++;
        if(minutes == 60){
            minutes = 0;
            hours++;
        }
        if (hours == 24){
            hours = 0;
        }
        if (hours < 10){
            if (minutes < 10){
                time_run = "0"+hours+" : "+"0"+minutes;
            }
            else {
                time_run = "0"+hours+" : "+minutes;
            }
        }
        else if (hours >=10){
            if (minutes < 10){
                time_run = hours+" : "+"0"+minutes;
            }
            else {
                time_run =  hours+" : "+minutes;
            }
        }
    }

    @Override
    public void run() {
        Timer myTimer;
        myTimer = new Timer();

        while (true){
            timerTick();
            try {
                Thread.currentThread().sleep(Simulator.timestate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}