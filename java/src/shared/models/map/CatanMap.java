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

	/** The Hexes of the Map keyed to Hex Locations */
	Map<HexLocation,TerrainHex> hexes;
	/** The Roads currently on the map that the player of player index owns */
	Map<PlayerIndex,ArrayList<Road>> roads;
	/** The Buildings currently on the map that the player of player index owns */
	Map<PlayerIndex,Building> buildings;
	/** The Hex location of each number token */
	Map<PlayerIndex,ArrayList<HexLocation>> numberTokens;
	/** The Hex location of the Robber on the map */
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
