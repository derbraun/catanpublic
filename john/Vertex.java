package john;

import java.utils.List;

import john.Location;
import john.Edge;
import john.Hex;

public class Vertex extends Location {

	private List<Edge> edges;
	private List<Hex> hexes;
	private boolean settlement;
	private boolean city;

	public List<Edge> getEdges() {

	}

	public List<Hex> getHexes() {

	}

	public boolean hasSettlement() {

	}

	public boolean hasCity() {

	}

	public ResourceSet getResourcesForRoll(int number) {

	}

	public void buildSettlement() {
		settlement = true;
	}

	public void buildCity() {
		settlement = false;
		city = true;
	}

}