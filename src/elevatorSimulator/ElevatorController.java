package elevatorSimulator;

import java.util.*;

public class ElevatorController {
    private Vector elevators;
    private Vector floors;

    public ElevatorController(Vector floors, Vector elevators) {
        this.floors = floors;
        this.elevators = elevators;
    }

    public int getNumberWaitingUp(int floorNumber) {
        return getFloor(floorNumber).getNumberWaitingUp();
    }

    public int getNumberWaitingDown(int floorNumber) {
        return getFloor(floorNumber).getNumberWaitingDown();
    }

    public int getFloorStatus(int floorNumber) {
        return getFloor(floorNumber).getFloorStatus();
    }

    public void setFloorStatus(int status, int floorNumber) {
        getFloor(floorNumber).setFloorStatus(status);
    }

    public ElevatorState getElevatorState(int elevatorNumber) {
        return ((Elevator) elevators.get(elevatorNumber - 1)).getState();
    }

    public void summonElevatorUp(int floorNumber, Person person) {
        Elevator e = null;
        int counter = 0;
        while (e == null && person.getKeepRunning()) {
            e = getSameFloorElevator(floorNumber);
            if (e != null) {
                try {
                    e.summonDestination(floorNumber);
                } catch (Exception mx) {
                    e = null;
                    continue;
                }
            } else {
                if (floorNumber > 1) {
                    e = getNearestElevator(floorNumber, Elevator.MOVING_UP);
                }
                if (e != null) {
                    try {
                        e.summonDestination(floorNumber);
                    } catch (Exception mx) {
                        e = null;
                        continue;
                    }
                } else {
                    e = getNearestElevator(floorNumber, Elevator.NO_DIRECTION);
                    if (e != null) {
                        try {
                            e.summonDestination(floorNumber);
                        } catch (Exception mx) {
                            e = null;
                            continue;
                        }
                    } else {
                        e = getElevator(floorNumber, Elevator.MOVING_DOWN);
                        if (e != null) {
                            try {
                                e.summonDestination(floorNumber);
                            } catch (Exception mx) {
                                e = null;
                                continue;
                            }
                        }
                    }
                }
            }
            if (e == null) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException ix) {
                }
            }
        }
    }

    public void summonElevatorDown(int floorNumber, Person person) {
        Elevator e = null;
        int counter = 0;
        while (e == null && person.getKeepRunning()) {
            e = getSameFloorElevator(floorNumber);
            if (e != null) {
                try {
                    e.summonDestination(floorNumber);
                } catch (Exception mx) {
                    e = null;
                    continue;
                }
            } else {
                if (floorNumber != Building.MAX_FLOORS) {
                    e = getNearestElevator(floorNumber, Elevator.MOVING_DOWN);
                }
                if (e != null) {
                    try {
                        e.summonDestination(floorNumber);
                    } catch (Exception mx) {
                        e = null;
                        continue;
                    }
                } else {
                    e = getNearestElevator(floorNumber, Elevator.NO_DIRECTION);
                    if (e != null) {
                        try {
                            e.summonDestination(floorNumber);
                        } catch (Exception mx) {
                            e = null;
                            continue;
                        }
                    } else {
                        e = getElevator(floorNumber, Elevator.MOVING_UP);
                        if (e != null) {
                            try {
                                e.summonDestination(floorNumber);
                            } catch (Exception mx) {
                                e = null;
                                continue;
                            }
                        }
                    }
                }
            }
            if (e == null) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException ix) {
                }
            }
        }
    }

    public Floor getFloor(int floorNumber) {
        return (Floor) floors.get(floorNumber - 1);
    }

    public void startElevators() {
        for (int i = 0; i < elevators.size(); i++) {
            ((Elevator) elevators.get(i)).start();
        }
    }

    public void elevatorArrived(int floorNumber, Elevator elevator) {
        int direction = elevator.getState().motionDirection;
        Floor floor = getFloor(floorNumber);
        if (direction == Elevator.MOVING_UP && floor.isSummonUp()) {
            floor.elevatorArrivedUp(elevator);
        } else if (direction == Elevator.MOVING_DOWN && floor.isSummonDown()) {
            floor.elevatorArrivedDown(elevator);
        } else if (floor.isSummonUp()) {
            floor.elevatorArrivedUp(elevator);
        } else if (floor.isSummonDown()) {
            floor.elevatorArrivedDown(elevator);
        } else if (floor.getNumberWaitingUp() > floor.getNumberWaitingDown()) {
            floor.elevatorArrivedUp(elevator);
        } else {
            floor.elevatorArrivedDown(elevator);
        }
    }

    private Elevator getSameFloorElevator(int floorNumber) {
        Elevator e = null;
        ElevatorState state = null;
        for (int i = 0; i < elevators.size(); i++) {
            e = (Elevator) elevators.get(i);
            state = e.getState();
            if (e.getCurrentFloorNumber() == floorNumber && state.motionState == Elevator.STOPPED && state.numberRiders == 0) {
                break;
            } else
                e = null;
        }
        return e;
    }

    private Elevator getNearestElevator(int floorNumber, int direction) {
        Elevator closestElevator = null;
        int closestFloor = 0;
        int closest = Building.MAX_FLOORS + 1;
        Elevator currentElevator = null;
        int currentFloorNumber = 0;
        for (int i = 0; i < elevators.size(); i++) {
            currentElevator = (Elevator) elevators.get(i);
            currentFloorNumber = currentElevator.getCurrentFloorNumber();
            if (direction == Elevator.MOVING_UP) {
                if (currentFloorNumber > closestFloor && currentFloorNumber < floorNumber) {
                    closestElevator = currentElevator;
                    closestFloor = currentFloorNumber;
                }
            } else if (direction == Elevator.MOVING_DOWN) {
                if (currentFloorNumber < closestFloor && currentFloorNumber > floorNumber) {
                    closestElevator = currentElevator;
                    closestFloor = currentFloorNumber;
                }
            } else if (direction == Elevator.NO_DIRECTION) {
                if (currentFloorNumber != floorNumber && Math.abs(currentFloorNumber - floorNumber) < closest) {
                    closestElevator = currentElevator;
                    closest = Math.abs(currentFloorNumber - floorNumber);
                }
            }
        }
        return closestElevator;
    }

    private Elevator getElevator(int floorNumber, int direction) {
        Elevator closestElevator = null;
        int closestFloor = 0;
        int closest = Building.MAX_FLOORS + 1;
        Elevator currentElevator = null;
        int currentFloorNumber = 0;
        for (int i = 0; i < elevators.size(); i++) {
            currentElevator = (Elevator) elevators.get(i);
            currentFloorNumber = currentElevator.getCurrentFloorNumber();
            if (direction == Elevator.MOVING_UP) {
                if (currentFloorNumber > closestFloor && currentFloorNumber < floorNumber) {
                    closestElevator = currentElevator;
                    closestFloor = currentFloorNumber;
                }
            } else if (direction == Elevator.MOVING_DOWN) {
                if (currentFloorNumber < closestFloor && currentFloorNumber > floorNumber) {
                    closestElevator = currentElevator;
                    closestFloor = currentFloorNumber;
                }
            }
        }
        return closestElevator;
    }
}


