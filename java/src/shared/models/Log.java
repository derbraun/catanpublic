package shared.models;

import java.utils.List;
import java.utils.ArrayList;

import shared.models.Note;
import shared.models.Player;

/** Used to store the data used in history and chat. Both use ordered
 * sequences of 'note' objects which contain a player and text content
 * to be displayed.
 */
class Log {

	private List<Note> notes;

	/** Constructor. Initializes the list of notes.
	 */
	public Log() {
		notes = new ArrayList<Note>();
	}

	/** Creates a note with the given player and text content, and adds
	 * it to the List.
	 * @param player the Player object the note is attached to
	 * @param content the text content of the note
	 */
	public void add(Player player, String content) {
		Note note = Note(player, content);
		notes.add(note);
	}

}