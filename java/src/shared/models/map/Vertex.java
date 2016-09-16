package shared.models.map;

import java.util.ArrayList;

import shared.definitions.PortType;
import shared.locations.EdgeLocation;
import shared.locations.VertexLocation;

public class Vertex {

	private Building building;
	private ArrayList<EdgeLocation> adjacentBorders;
	private ArrayList<VertexLocation> adjacentCorners;
	
	public boolean hasBuilding(){
		return false;
	}
	
	public boolean canPlaceSettlement(int pID){
		return false;
	}
	
	public void placeSettlement(int pID){
		
	}
	
	public boolean canUpgradeSettlement(int pID){
		return false;
	}
	
	public void upgradeSettlement(int pID){
		
	}
	
	public boolean isOnPort(PortType type){
		return false;
	}
}
