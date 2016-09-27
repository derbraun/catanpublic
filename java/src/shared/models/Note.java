package shared.models;

import com.google.gson.JsonObject;
import shared.models.exceptions.JsonStructureException;

/**
 * Stores a single history item (move) or chat item (comment). It
 * contains data on which player the move/comment is associated with and
 * what the actual text content of the note is.
 */
public class Note {

	final private Player player;
	final private String content;

	/**
	 * Constructor. Takes a Player and a String, associates the note
	 * with that player, and sets its content to the String. After this,
	 * the note is immutable.
	 * 
	 * @param aPlayer the Player to associate the Note with
	 * @param aContent the text content of the note
	 */
	public Note(Player aPlayer, String aContent) {
		player = aPlayer;
		content = aContent;
	}

	/**
	 * Constructor. Builds the note from a JsonObject provided by the
	 * server when polling.
	 * 
	 * @param json the JsonObject containing the data to initialize the
	 * Note object.
	 * @throws JsonStructureException if the structure of the provided
	 * json is incorrect.
	 */
	public Note(JsonObject json) throws JsonStructureException,
			Player.DoesNotExistException {
		try {
			String playerName = json.get("source").getAsString();
			player = Player.getByName(playerName);
			content = json.get("message").getAsString();
		} catch(ClassCastException | IllegalStateException ex) {
			throw new JsonStructureException(ex);
		}
	}

	public Player getPlayer() {
		return player;
	}

	public String getContent() {
		return content;
	}

}