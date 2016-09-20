package shared.models.map;

import java.util.ArrayList;
import java.util.Map;

import shared.definitions.PlayerIndex;
import shared.definitions.PortType;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;

/**
 * The default Catan Map that is made up of Hexes, Edges, Vertices, and Ports.
 * Certain Game pieces may be placed on the map including buildings, roads, 1 robber, and number tokens.
 * 
 */
public class CatanMap implements ICatanMap {

	Map<HexLocation,TerrainHex> hexes;
	Map<PlayerIndex,Road> roads;
	Map<PlayerIndex,Building> buildings;
	Map<PlayerIndex,ArrayList<HexLocation>> numberTokens;
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
	public boolean canPlaceRoad(PlayerIndex pIndex, EdgeLocation loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void placeRoad(PlayerIndex pIndex, EdgeLocation loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canPlaceSettlement(PlayerIndex pIndex, VertexLocation loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void placeSettlement(PlayerIndex pIndex, VertexLocation loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canUpgradeSettlement(PlayerIndex pIndex, VertexLocation loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void upgradeSettlement(PlayerIndex pIndex, VertexLocation loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLongestRoadOfPlayer(PlayerIndex pIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResProdResult getResourceProductionResults(int dieRoll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doesPlayerHavePort(PlayerIndex pIndex, PortType type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numRoadsOfPlayer(PlayerIndex pIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numSettlementsOfPlayer(PlayerIndex pIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numCitiesOfPlayer(PlayerIndex pIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

}
