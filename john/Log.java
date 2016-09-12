package john;

import java.util.List;

import john.Note;

/** A class for keeping track of an ordered sequence of notes, such as
 * game history or chat comments.
 */
public class Log {

	private List<Note> notes;

	public Log() {
		
	}

	/**
	 * @return a list of the notes contained in the log
	 */
	public List<Note> getNotes() {
		return notes;
	}

	/** appends a note on the end of the list
	 * @param note the note to append
	 */
	public void addNote(Note note) {
		notes.add(note);
	}

}