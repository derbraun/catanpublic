package shared.models.map;

import java.util.ArrayList;
import java.util.Map;

import shared.definitions.PortType;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;

public class CatanMap implements ICatanMap {

	Map<HexLocation,TerrainHex> hexes;
	Map<Integer,Road> roads;
	Map<Integer,Building> buildings;
	Map<Integer,ArrayList<HexLocation>> numberTokens;
	HexLocation robber;
	
	@Override
	public boolean canPlaceRobber(HexLocation loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void placeRobber(HexLocation loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canPlaceRoad(int pID, EdgeLocation loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void placeRoad(int pID, EdgeLocation loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canPlaceSettlement(int pID, VertexLocation loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void placeSettlement(int pID, VertexLocation loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canUpgradeSettlement(int pID, VertexLocation loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void upgradeSettlement(int pID, VertexLocation loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLongestRoadOfPlayer(int pID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResProdResult getResourceProductionResults(int dieRoll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doesPlayerHavePort(int pID, PortType type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numRoadsOfPlayer(int pID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numSettlementsOfPlayer(int pID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numCitiesOfPlayer(int pID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
