package shared.models.map;

import java.util.ArrayList;

import shared.definitions.PortType;
import shared.locations.EdgeLocation;
import shared.locations.VertexLocation;

public class Edge {

	private Road road;
	private ArrayList<EdgeLocation> adjacentBorders;
	private ArrayList<VertexLocation> adjacentCorners;
	private Port port;
	
	public boolean hasRoad(){
		return false;
	}
	
	public boolean hasRoadOfPlayer(int pID){
		return false;
	}
	
	public boolean canPlaceRoad(int pID){
		return false;
	}
	
	public void placeRoad(int pID){
		
	}
	
	public boolean hasPort(PortType type){
		return false;
	}
	
	public int findLongestRoadRescursive(){
		return 0;
	}
}
