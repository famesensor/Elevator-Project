package elevatorSimulator;

public class Person extends PoissonDis implements Runnable {
    public static final int WAITING = 1;
    public static final int WORKING = 3;
    public static final int WALKING_OUTSIDE = 4;
    public static final int RIDING = 5;
    public static final int GOING_NOWHERE = -1;
    public static final int OUTSIDE = -1;
    public static final int IN_ELEVATOR = 0;
    private static Building building;
    private int personID;
    private int destination;
    private int location;
    private long activityTime;
    private int activity;
    private Elevator elevator;
    private Floor floor;
    private Thread activePerson;
    private volatile boolean keepRunning;


    public static void setBuilding(Building theBuilding) {
        building = theBuilding;
    }

    public Person(int personID) {
        this.personID = personID;
    }

    public void setStopRunning() {
        this.keepRunning = false;
    }

    public boolean getKeepRunning() {
        return keepRunning;
    }

    public synchronized void attention() {
        activePerson.interrupt();
    }

    public synchronized void elevatorArrived(Elevator elevator) {
        this.elevator = elevator;
    }


    public void start() {
        destination = GOING_NOWHERE;
        activity = WALKING_OUTSIDE;
        keepRunning = true;
        if (activePerson == null) {
            activePerson = new Thread(this);
            activePerson.setPriority(Thread.NORM_PRIORITY - 2);
            activePerson.start();
        }
    }

    public void run() {
        while (keepRunning) {
            decided();
            if(this.destination == GOING_NOWHERE && this.location == OUTSIDE && this.activity == WALKING_OUTSIDE){
                setStopRunning();
            }
        }
    }

    private void decided() {
        switch (activity) {
            case WALKING_OUTSIDE:
                    if (wantsToEnter()) {
                    building.peopleOutside--;
                    setDestination();
                    floor = building.enterBuilding();
                    location = floor.getFloorNumber();
                    if (destination > location) {
                        activity = WAITING;
                        setWaitTime();
                        floor.summonElevatorUp(this);
                        action();
                    } else {
                        building.peopleWorking++;
                        activity = WORKING;
                        destination = GOING_NOWHERE;
                        setWaitTime();
                        action();
                    }
                } else {
                    destination = GOING_NOWHERE;
                    location = OUTSIDE;
                    activity = WALKING_OUTSIDE;
                    setWaitTime();
                    action();
                }
                break;
            case WAITING:
                if (elevator != null) {
                    enterElevator();
                } else {
                    setWaitTime();
                    action();
                }
                break;
            case WORKING:
                if (location == 1) {
                    if (wantsToLeave()) {
                        building.peopleOutside++;
                        building.peopleWorking--;
                        destination = GOING_NOWHERE;
                        location = OUTSIDE;
                        activity = WALKING_OUTSIDE;
                        setWaitTime();
                        action();
                    } else {
                        setDestination();
                        if (destination > location) {
                            building.peopleWorking--;
                            activity = WAITING;
                            setWaitTime();
                            floor.summonElevatorUp(this);
                            action();
                        } else {
                            activity = WORKING;
                            destination = GOING_NOWHERE;
                            setWaitTime();
                            action();
                        }
                    }
                } else {
                    setDestination();
                    if (destination > location) {
                        building.peopleWorking--;
                        activity = WAITING;
                        setWaitTime();
                        floor.summonElevatorUp(this);
                        action();
                    } else if (destination < location) {
                        building.peopleWorking--;
                        activity = WAITING;
                        setWaitTime();
                        floor.summonElevatorDown(this);
                        action();
                    } else {
                        activity = WORKING;
                        destination = GOING_NOWHERE;
                        setWaitTime();
                        action();
                    }
                }
                break;
            case RIDING:
                if (elevator.getCurrentFloorNumber() == destination) {
                    leaveElevator();
                } else {
                    setWaitTime();
                    action();
                }
                break;
        }
    }

    private boolean wantsToEnter() {
        double i = (Math.random() * 1000);
        if (i < 600) return true;
        else return false;
    }

    private void setDestination() {
        destination = (int) (Math.random() * Building.MAX_FLOORS) + 1;
    }

    private void setWaitTime() {
        activityTime = 1000 * (int)((Math.random()*50)+1);
    }

    private void setWorkingTime() {
        activityTime = 1000 * (int)((Math.random()*5)+1)*2;
    }

    private boolean wantsToLeave() {
        double i = (Math.random() * 10000);
        if (i < 6600) return true;
        else return false;
    }

    private void action() {
        try {
            activePerson.sleep(activityTime);
        } catch (InterruptedException ix) {
        }
    }

    private void enterElevator() {
        try {
            elevator.enterElevator(this);
            elevator.setDestination(destination);
            floor.stopWaiting(this);
            floor = null;
            location = IN_ELEVATOR;
            activity = RIDING;
            activityTime = Elevator.FLOOR_TRAVEL_TIME * Math.abs(location - destination);
            action();
        } catch (Exception fx) {
            resetWaitForElevator();
            try {
                elevator.requestOpenDoor();
            } catch (Exception mx) {
                resetWaitForElevator();
            }
        }
    }

    private void leaveElevator() {
        try {
            elevator.leaveElevator(this);
            floor = building.getFloor(destination);
            location = destination;
            destination = GOING_NOWHERE;
            activity = WORKING;
            building.peopleWorking++;
            setWorkingTime();
            action();
        } catch (Exception dx) {
            try {
                elevator.requestOpenDoor();
            } catch (Exception mx) {
                elevator.setDestination(destination);
            }
        }
    }

    private void resetWaitForElevator() {
        floor.stopWaiting(this);
        elevator = null;
        setWaitTime();
        action();
        if (destination > location)
            floor.summonElevatorUp(this);
        else
            floor.summonElevatorDown(this);
    }
}


