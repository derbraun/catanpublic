package shared.models;

import java.util.Iterator;
import java.util.List;

/**
 * Iterator class used by the Log class to make it iterable. If you want
 * to know what each of these methods does, you can refer to the
 * documentation on the
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html">
 * Iterator Interface</a>. Note that the optional remove function is not
 * supported, because there shouldn't be any reason for a Log to remove
 * a note once it has been added.
 */
public class NoteIterator implements Iterator<Note> {
	
	List<Note> notes;
	int currentIndex;
	
	public NoteIterator(List<Note> someNotes) {
		currentIndex = 0;
		notes = someNotes;
	}

	public boolean hasNext() {
		return currentIndex < notes.size() - 1;
	}

	public Note next() {
        currentIndex++;
		return notes.get(currentIndex);
	}

	/**
	 * Optional method of the Iterator interface. Not implemented,
	 * because there is no reason for a Note to be removed from a Log
	 * once it has been added.
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

}