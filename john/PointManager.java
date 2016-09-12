package john;

public class PointManager {

	private int points;

	public void addPoint() {
		points++;
	}

	public void addPoints(int numPoints) {
		points += numPoints;
	}

	public void removePoint() {
		points--;
	}

	public void removePoints(int numPoints) {
		points -= numPoints;
	}

	public int getNumPoints() {
		return points;
	}

}