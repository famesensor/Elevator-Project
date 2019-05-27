package newSim;

public interface ElevatorSim {
    public static final int UP = 1;
    public static final int DOWN = -1;
    public static final int NODIRECTION = 0;
    public static final int ESCKEY = 27;
    public static final int MAXELEVS = 10;		// Number of elevators (1 to 10 only)
    public static final int MAXFLOORS = 10;	// Number of floors (2 to 10 only)
    public static final int MAXPERSONS = 500;	// Maximum people in building
    public static final int ELEVWAIT = 15;		// Min. seconds to wait at floors
    public static final int CAPACITY = 24;		// Maximum people in an elevator
    public static final int TRAVELTIME = 5;	// Seconds to travel between floors
}