package john;

import java.util.List;

import john.Location;
import john.Edge;
import john.Hex;

/** a point where a settlement can be built
 */
public class Vertex extends Location {

	private List<Edge> edges;
	private List<Hex> hexes;
	private boolean settlement;
	private boolean city;

	/**
	 * @return a list of all edges adjacent to the vertex
	 */
	public List<Edge> getEdges() {

	}

	/**
	 * @return a list of all hexes adjacent to the vertex
	 */
	public List<Hex> getHexes() {

	}

	/**
	 * @return a list of all neighboring vertexes
	 */
	public List<Vertex> getVertices() {

	}

	/**
	 * @return true if there is a settlement built on the vertex, false
	 * otherwise
	 */
	public boolean hasSettlement() {

	}

	/**
	 * @return true if there is a city built on the vertex, false
	 * otherwise
	 */
	public boolean hasCity() {

	}

	/** gets an object containing information about the resources a
	 * player should get from the vertex when the given number is
	 * rolled. A city vertex should yield 2 resources from each
	 * adjacent hex with the number rolled, a settlement vertex should
	 * yield one for each, and an empty vertex should yield zero of each
	 * resource.
	 * @param number the number rolled
	 * @return an object containing information on the number of
	 * resources the vertex should yield
	 */
	public ResourceSet getResourcesForRoll(int number) {

	}

	/** sets an empty vertex to a settlement vertex
	 */
	public void buildSettlement() {
		settlement = true;
	}

	/** changes a settlement vertex to a city vertex
	 */
	public void buildCity() {
		settlement = false;
		city = true;
	}

}