package john;

import java.util.List;

import john.Note;

public class Log {

	private List<Note> notes;

	public Log() {
		
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void addNote(Note note) {
		notes.add(note);
	}

}