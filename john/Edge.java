package john;

import java.util.List;

import john.Vertex;
import john.Hex;

/** a hex edge where a road can be built
 */
public class Edge {

	private List<Vertex> vertices;
	private List<Hex> hexes;
	private boolean road;

	/**
	 * @return a list of all adjacent Vertex objects
	 */
	public List<Vertex> getVertices() {

	}

	/**
	 * @return a list of all adjacent Hex objects
	 */
	public List<Hex> getHexes() {

	}

	/**
	 * @return a list of all neighboring Edge objects
	 */
	public List<Edge> getEdges() {

	}

	/**
	 * @return true if the edge has a road on it, otherwise false
	 */
	public boolean hasRoad() {
		return road;
	}

	/**
	 * @return true if a road can be built on the hex, otherwise false
	 */
	public boolean canBuild() {

	}

	/** build a road on the edge
	*/
	public void buildRoad() {
		road = true;
	}

}