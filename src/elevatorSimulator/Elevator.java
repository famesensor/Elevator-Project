package elevatorSimulator;

import java.util.*;

public class Elevator implements Runnable {
    public static final int MOVING_UP = 1;
    public static final int NO_DIRECTION = 0;
    public static final int MOVING_DOWN = -1;
    public static final int MOVING = 1;
    public static final int STOPPED = 0;
    public static final int DOOR_OPEN = 2;
    public static final int DOOR_CLOSED = -2;
    private static long FLOOR_WAIT_TIME = Simulator.timestate * 2;
    protected static int FLOOR_TRAVEL_TIME = Simulator.timestate;
    private static long INACTIVE_TIME = Simulator.timestate;
    protected static int MAX_OCCUPANCY; // TODO: max person in each elevator
    private int elevatorID;
    private int doorState;
    private int motionState;
    private int motionDirection;
    private volatile int currentFloorNumber;
    private boolean requestDoorOpen;
    private boolean[] destinationList = new boolean[Building.MAX_FLOORS]; // of type int
    private static ElevatorController elevatorController;
    private Vector riders = new Vector();
    private Thread activeElevator;
    private volatile boolean keepRunning;
    private ElevatorState state = new ElevatorState();

    public Elevator(int elevatorNumber) {
        elevatorID = elevatorNumber;
        for (int i = 0; i < destinationList.length; i++) {
            destinationList[i] = false;
        }
        motionDirection = NO_DIRECTION;
        currentFloorNumber = 1;
        motionState = STOPPED;
        doorState = DOOR_CLOSED;
    }

    public static int getMaxOccupancy() {
        return MAX_OCCUPANCY;
    }

    public static void setElevatorController(ElevatorController controller) {
        elevatorController = controller;
    }

    public synchronized void setDestination(int floorNumber) {
        if (riders.isEmpty() && motionState == STOPPED) {
            destinationList[floorNumber - 1] = true;
            activeElevator.interrupt();
        } else {
            destinationList[floorNumber - 1] = true;
        }
    }

    public synchronized void summonDestination(int floorNumber) throws Exception {
        if (getCurrentFloorNumber() != floorNumber || riders.isEmpty()) {
            destinationList[floorNumber - 1] = true;
            activeElevator.interrupt();
        } else {
            throw new Exception();
        }
    }

    public synchronized void requestOpenDoor() throws Exception {
        if (motionState == STOPPED)
            requestDoorOpen = true;
        else
            throw new Exception();
    }

    public int getCurrentFloorNumber() {
        return currentFloorNumber;
    }

    public void start() {
        keepRunning = true;
        if (activeElevator == null) {
            activeElevator = new Thread(this);
            activeElevator.setPriority(Thread.NORM_PRIORITY - 1);
            activeElevator.start();
        }
    }

    public void run() {
        while (keepRunning) {
            switch (motionState) {
                case STOPPED:
                    if (riders.isEmpty() && !isDestination()) {
                        motionDirection = NO_DIRECTION;
                        action(INACTIVE_TIME);
                    } else if (isArrived()) {
                        openDoor();
                        closingDoor();
                        removeDestination();
                    } else {
                        travel();
                    }
                    break;
                case MOVING:
                    if (isArrived()) {
                        stopElevator();
                    } else {
                        travel();
                    }
                    break;
            }
        }
    }

    public void leaveElevator(Person person) throws Exception {
        if (doorState == DOOR_OPEN) {
            riders.remove(person);
            motionDirection = DOOR_OPEN;
        } else {
            throw new Exception();
        }
    }

    public void enterElevator(Person person) throws Exception {
        if (doorState == DOOR_OPEN) {
            if (riders.size() < MAX_OCCUPANCY) {
                riders.add(person);
                motionDirection = DOOR_OPEN;
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    public ElevatorState getState() {
        state.elevatorID = elevatorID;
        state.currentFloorNumber = currentFloorNumber;
        state.motionState = motionState;
        state.motionDirection = motionDirection;
        state.numberRiders = riders.size();
        state.doorState = doorState;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < destinationList.length; i++) {
            sb.append(destinationList[i] ? "1" : "0");
        }
        state.destinations = sb.toString();
        return state;
    }

    private void action(long time) {
        try {
            activeElevator.sleep(time);
        } catch (InterruptedException ix) {
        }
    }

    private synchronized boolean isArrived() {
        boolean returnValue = false;
        if (destinationList[currentFloorNumber - 1]) {
            returnValue = true;
            motionState = STOPPED;
        }
        return returnValue;
    }

    private void moveUp() {
        if (isDestinationAbove()) {
            if (currentFloorNumber != Building.MAX_FLOORS) {
                action(FLOOR_TRAVEL_TIME);
                ++currentFloorNumber;
            }
        } else if (isDestinationBelow()) {
            motionDirection = MOVING_DOWN;
        } else {
            stopElevator();
        }
    }

    private void moveDown() {
        if (isDestinationBelow()) {
            if (currentFloorNumber != 1) {
                action(FLOOR_TRAVEL_TIME);
                --currentFloorNumber;
            }
        } else if (isDestinationAbove()) {
            motionDirection = MOVING_UP;
        } else {
            stopElevator();
        }
    }

    private void openDoor() {
        if (doorState == DOOR_CLOSED && motionState == STOPPED) {
            doorState = DOOR_OPEN;
            motionDirection = DOOR_OPEN;
            notifyRiders();
            notifyController();
            action(FLOOR_WAIT_TIME);
        }
    }

    private void closingDoor() {
        do {
            resetDoorRequest();
            notifyRiders();
            notifyController();
            action(500);
        } while (isRequestDoorOpen());
        doorState = DOOR_CLOSED;
        motionDirection = DOOR_CLOSED;
    }

    private synchronized void resetDoorRequest() {
        requestDoorOpen = false;
    }

    private synchronized boolean isRequestDoorOpen() {
        return requestDoorOpen;
    }

    private void notifyRiders() {
        synchronized (riders) {
            for (int i = 0; i < riders.size(); i++) {
                ((Person) riders.get(i)).attention();
            }
        }

    }

    private void notifyController() {
        elevatorController.elevatorArrived(currentFloorNumber, this);
    }

    private synchronized void travel() {
        if (isDestination()) {
            motionState = MOVING;
            if (motionDirection == MOVING_UP) {
                moveUp();
            } else if (motionDirection == MOVING_DOWN) {
                moveDown();
            } else if (isDestinationAbove()) {
                motionDirection = MOVING_UP;
                moveUp();
            } else if (isDestinationBelow()) {
                motionDirection = MOVING_DOWN;
                moveDown();
            } else {
                stopElevator();
            }
        } else {
            motionDirection = NO_DIRECTION;
            motionState = STOPPED;
            action(INACTIVE_TIME);
        }
    }

    private synchronized void removeDestination() {
        destinationList[currentFloorNumber - 1] = false;
    }

    private void stopElevator() {
        motionState = STOPPED;
    }

    private synchronized boolean isDestination() {
        boolean returnValue = false;
        for (int i = 0; i < destinationList.length; i++) {
            if (destinationList[i]) {
                returnValue = true;
                break;
            }
        }
        return returnValue;
    }

    private synchronized boolean isDestinationAbove() {
        boolean returnValue = false;
        for (int i = getCurrentFloorNumber(); i < destinationList.length; i++) {
            if (destinationList[i]) {
                returnValue = true;
                break;
            }
        }
        return returnValue;
    }

    private synchronized boolean isDestinationBelow() {
        boolean returnValue = false;
        for (int i = getCurrentFloorNumber() - 2; i >= 0; i--) {
            if (destinationList[i]) {
                returnValue = true;
                break;
            }
        }
        return returnValue;
    }
}


