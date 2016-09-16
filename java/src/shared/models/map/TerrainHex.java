package shared.models.map;

import java.util.Map;

import shared.definitions.HexType;
import shared.definitions.PortType;
import shared.locations.EdgeDirection;
import shared.locations.HexLocation;
import shared.locations.VertexDirection;

public class TerrainHex {
	private HexLocation location;
	private HexType terrainType;
	private int NumberToken;
	private Map<VertexDirection,Vertex> vertices;
	private Map<EdgeDirection,Edge> edges;
	
	
	public TerrainHex(HexLocation location, HexType terrainType, int numberToken) {
		super();
		this.location = location;
		this.terrainType = terrainType;
		NumberToken = numberToken;
	}

	public boolean canPlaceRoad(int pID, EdgeDirection loc) {
		return false;
	}

	public void placeRoad(int pID, EdgeDirection loc) {

	}

	public boolean canPlaceSettlement(int pID, VertexDirection loc) {
		return false;
	}

	public void placeSettlement(int pID, VertexDirection loc) {

	}

	public boolean canUpgradeSettlement(int pID, VertexDirection loc) {
		return false;
	}

	public void upgradeSettlement(int pID, VertexDirection loc) {

	}
	
	public int findLongestRoad(int pID, EdgeDirection dir){
		return 0;
	}
	
	public boolean isBuildingOnPort(VertexDirection dir, PortType type){
		return false;
	}
	
}
