package john;

/** A class for managing and keeping track of a single player's points
 */
public class PointManager {

	private int points;

	/** gives the player a point
	 */
	public void addPoint() {
		points++;
	}

	/** adds the specified number of points to the player's score
	 * @param numPoints the number of points to add
	 */
	public void addPoints(int numPoints) {
		points += numPoints;
	}

	/** takes away one point from the player
	 */
	public void removePoint() {
		points--;
	}

	/** removes the specified number of points from the player's score
	 * @param numPoints the number of points to remove
	 */
	public void removePoints(int numPoints) {
		points -= numPoints;
	}

	/**
	 * @return the number of points the player has
	 */
	public int getNumPoints() {
		return points;
	}

}