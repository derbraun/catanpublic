package shared.models;

import java.util.List;
import java.util.ArrayList;
import com.google.gson.JsonObject;
import java.util.Iterator;
import shared.models.exceptions.JsonStructureException;

/**
 * Used to store the data used in history and chat. Both use ordered
 * sequences of 'note' objects which contain a player and text content
 * to be displayed.
 */
public class Log implements Iterable<Note> {

	private List<Note> notes;

	/**
	 * Constructor. Initializes as empty.
	 */
	public Log() {
		notes = new ArrayList<Note>();
	}

	/**
	 * Constructor. Initializes based on the JsonObject returned from
	 * the server when polling.
	 * 
	 * @param json the JsonObject from which to initialize the Log
	 * object.
	 * @pre json is an object with the single property "lines", an array
	 * of objects with the string properties "source" and "message".
	 * @throws JsonStructureException if json does not have the correct
	 * structure.
	 */
	public Log(JsonObject json) throws JsonStructureException {

	}

	/**
	 * Creates a note with the given player and text content, and adds
	 * it to the List.
	 * 
	 * @param player the Player object the note is attached to
	 * @param content the text content of the note
	 */
	public void add(Player player, String content) {
		Note note = new Note(player, content);
		notes.add(note);
	}

	/**
	 * A Log object has two operations: adding a Note object to the end
	 * of its list, and iterating through the Note objects. In order to
	 * do this, it implements Iterable by including this function which
	 * returns an iterator for it.
	 */
	public Iterator<Note> iterator() {
            return null;
	}

}