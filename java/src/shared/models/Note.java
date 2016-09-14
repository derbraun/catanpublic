package shared.models;

import shared.models.Player;

/** Stores a single history item (move) or chat item (comment). It
 * contains data on which player the move/comment is associated with and
 * what the actual text content of the note is.
 */
class Note {

	final private Player player;
	final private String content;

	/** Constructor. Takes a Player and a String, associates the note
	 * with that player, and sets its content to the String. After this,
	 * the note is immutable.
	 * @param aPlayer the Player to associate the Note with
	 * @param aContent the text content of the note
	 */
	public Note(Player aPlayer, String aContent) {
		player = aPlayer;
		content = aContent;
	}

}