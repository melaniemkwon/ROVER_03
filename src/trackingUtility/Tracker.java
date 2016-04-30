package trackingUtility;

import java.util.Stack;

import common.Coord;

public class Tracker {

	// Will have location coordinate and direction rover went in a string  
	private Stack<String> stuckMarkers;
	
	private Coord returnLocation;
	private Coord targetLocation;
	
	private Coord startingPoint;
	private Coord destination;
	
	public boolean blocked;
	
	public boolean blockedEast = false;
	public boolean blockedWest = false;
	public boolean blockedNorth = false;
	public boolean blockedSouth = false;

	public boolean goingNorth = false;
	public boolean goingSouth = false;
	public boolean goingEast = false;
	public boolean goingWest = false;

	public boolean wait = false;

	// Keeps track of how may tiles are left to go
	private Coord distanceTracker;

	public Tracker(){
		distanceTracker = new Coord(0,0);
	}
	
	// It just peeks the last point where rover got stuck
	public String backtrack(){
		return stuckMarkers.peek();
	}
	
	public void removeMarker(){
		stuckMarkers.pop();
	}
	
	public void setMarker(String locDir){
		stuckMarkers.add(locDir);
	}

	public Coord getReturnLocation() {
		return returnLocation;
	}

	public void setReturnLocation(Coord returnLocation) {
		this.returnLocation = returnLocation;
	}

	public Coord getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(Coord targetLocation) {
		this.targetLocation = targetLocation;
	}

	public Coord getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(Coord startingPoint) {
		this.startingPoint = startingPoint;
	}

	public Coord getDestination() {
		return destination;
	}

	public void setDestination(Coord destination) {
		this.destination = destination;
	}

	public Coord getDistanceTracker() {
		return distanceTracker;
	}

	public void setDistanceTracker() {
		distanceTracker.xpos = destination.xpos - startingPoint.xpos;
		distanceTracker.ypos = destination.ypos - startingPoint.ypos;
	}

	public void updateXPos(int x){
		distanceTracker.xpos += x; 
	}

	public void updateYPos(int y){
		distanceTracker.ypos += y; 
	}

	public boolean hasArrived(){
		return distanceTracker.xpos == 0 && distanceTracker.ypos == 0;
	}

	public boolean isBlocked(){
		return blocked;
	}
}
