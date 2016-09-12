package john;

import john.Player;

/** contains information about a single note in a Log object
 */
public class Note {

	private Player player;
	private String contents;

	/** constructor
	 * @param player the player associated with the action or comment
	 * @param contents the text of the note
	 */
	public Note(Player player, String contents) {

	}

	/**
	 * @return the player associated with this Note
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the text contents of the Note
	 */
	public String getContentes() {
		return contents;
	}

}