package chapter5.variantA.notepad;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import chapter5.exception.ErrorMessage;
import chapter5.exception.MyException;

/**
 * Defines logical entity of the notepad. Using an inner class "Note" for create notes.
 * 
 * @author јхтырскийёра
 *
 */
public class Notepad {
	private Note[] notes;
	private int size;
	private int capacity;
	private final int stepSize=10;
	
	//**************** Constructor ******************
	public Notepad() {
		size=stepSize;
		notes=new Note[size];
		capacity=-1;
	}
	
	//***************** Methods *******************
	/**
	 * Added note in the end of array.
	 * 
	 * @param date - note's date.
	 * @param note - note.
	 * @throws MyException - throws if incorrect parameters.
	 */
	public void addNote(Date date, String note) throws MyException {
		//parameters check
		if(date==null || note==null || note.isEmpty()) {
			throw new MyException(ErrorMessage.INCORRECT_PARAMETER);
		}
		//addition
		Note temp=new Note(date, note);
		capacity++;
		//if array is full increase array size by 10
		if(capacity==size) {
			size+=stepSize;
			Note[] tempNotes=new Note[size];
			for(int i=0; i<notes.length; i++) {
				tempNotes[i]=notes[i];
			}
			notes=tempNotes;
		}
		notes[capacity]=temp;
	}
	
	/**
	 * Deletes note from the end of array.
	 */
	public void deleteNote() {
		if(capacity>0) {
			notes[capacity]=null;
			capacity--;
		}
	}
	
	//**************** Overridden methods ****************
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<=capacity; i++) {
			sb.append(notes[i]).append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Inner class. Defines logical entity of the note.
	 * 
	 * @author јхтырскийёра
	 *
	 */
	private class Note{
		private Date date;
		private String note;
		
		//Constructor
		public Note() {}
		
		public Note(Date date, String note) {
			this.date=date;
			this.note=note;
		}
		
		//Getters and setters
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}
		
		//Overridden methods
		@Override
		public String toString() {
			StringBuilder sb=new StringBuilder();
			Date dateNow=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd");
			sb.append(format.format(dateNow)).append(": \"").append(note).append("\"");
			return sb.toString();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj==this) {
				return true;
			}
			if(obj==null || !(obj instanceof Note)) {
				return false;
			}
			Note temp=(Note) obj;
			if(!temp.getDate().equals(this.date) || !temp.getNote().equals(this.note)) {
				return false;
			}
			return true;
		}
		
		@Override
		public int hashCode() {
			return 31*this.date.hashCode() + this.note.hashCode();
		}
	}
}
