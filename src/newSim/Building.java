package newSim;
import java.util.*;
public class Building {
    protected static int MAX_FLOORS; // TODO: number of floors
    protected static int MAX_ELEVATORS; //TODO: number of elevators
    public ElevatorController elevatorController;
    public  volatile int peopleTakingStairs;
    public volatile int peopleOutside = Simulator.MAX_PEOPLE;
    public volatile int peopleWorking;
    public Building(){
        Vector floors = new Vector();
        for(int i = 0; i < MAX_FLOORS; i++){
            Floor f = new Floor(i + 1);
            floors.add(f);
        }
        Vector elevators = new Vector();
        for(int i = 0; i < MAX_ELEVATORS; i++){
            Elevator e = new Elevator(i + 1);
            elevators.add(e);
        }
        elevatorController = new ElevatorController(floors, elevators);
        Floor.setElevatorController(elevatorController);
        Elevator.setElevatorController(elevatorController);
        elevatorController.startElevators();
    }
    public ElevatorState getElevatorState(int elevatorNumber){
        return elevatorController.getElevatorState(elevatorNumber);
    }
    public int getNumberWaitingUp(int floorNumber){
        return elevatorController.getNumberWaitingUp(floorNumber);
    }
    public int getNumberWaitingDown(int floorNumber){
        return elevatorController.getNumberWaitingDown(floorNumber);
    }
    public int getFloorStatus(int floorNumber){
        return elevatorController.getFloorStatus(floorNumber);
    }
    public void setFloorStatus(int status ,int floorNumber){
        elevatorController.setFloorStatus(status ,floorNumber);
    }
    public Floor getFloor(int floorNumber) {
        return elevatorController.getFloor(floorNumber);
    }
    public Floor enterBuilding(){
        return getFloor(1);
    }
    public void stopElevators(){
        elevatorController.stopElevators();
    }
}