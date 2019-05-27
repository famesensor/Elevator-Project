package elevatorSimulator;

import java.util.*;

public class Floor {
    private int floorNumber;
    private volatile boolean summonUp;
    private volatile boolean summonDown;
    private Vector upWaiting = new Vector();
    private Vector downWaiting = new Vector();
    private static ElevatorController elevatorController;
    private int PersonUp;
    private int PersonDown;
    private int floorStatus = 0;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        PersonUp = 0;
        PersonDown = 0;
    }

    public int getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(int i) {
        floorStatus = i;
    }

    public boolean isSummonUp() {
        return summonUp;
    }

    public boolean isSummonDown() {
        return summonDown;
    }

    public static void setElevatorController(ElevatorController controller) {
        elevatorController = controller;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getNumberWaitingUp() {
        return PersonUp;
    }

    public int getNumberWaitingDown() {
        return PersonDown;
    }

    public void summonElevatorUp(Person person) {
        upWaiting.add(person);
        PersonUp++;
        if (!summonUp) {
            elevatorController.summonElevatorUp(floorNumber, person);
            summonUp = true;
        }
    }

    public void summonElevatorDown(Person person) {
        downWaiting.add(person);
        PersonDown++;
        if (!summonDown) {
            elevatorController.summonElevatorDown(floorNumber, person);
            summonDown = true;
        }
    }

    public void elevatorArrivedUp(Elevator elevator) {
        Person p = null;
        summonUp = false;
        int avaiable = Elevator.getMaxOccupancy() - elevator.getState().numberRiders;

        if(avaiable - PersonUp <= 0){
            PersonUp = Math.abs(avaiable - PersonUp);
        }else{
            PersonUp = 0;
        }
        synchronized (upWaiting) {
            for (int i = 0; i < upWaiting.size(); i++) {
                p = (Person) upWaiting.get(i);

                p.elevatorArrived(elevator);
                p.attention();
            }
            floorStatus = 1;
        }
    }

    public void elevatorArrivedDown(Elevator elevator) {
        Person p = null;
        summonDown = false;
        int avaiable = Elevator.getMaxOccupancy() - elevator.getState().numberRiders;

        if(avaiable - PersonDown <= 0){
            PersonDown = Math.abs(avaiable - PersonDown);
        }else{
            PersonDown = 0;
        }
        synchronized (downWaiting) {
            for (int i = 0; i < downWaiting.size(); i++) {
                p = (Person) downWaiting.get(i);

                p.elevatorArrived(elevator);
                p.attention();
            }
            floorStatus = -1;
        }


    }

    public void stopWaiting(Person person) {
        upWaiting.remove(person);
        downWaiting.remove(person);
    }
}


