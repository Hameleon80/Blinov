package chapter5.variantA;

import java.util.Date;

import chapter5.exception.MyException;
import chapter5.variantA.notepad.Notepad;

public class Runner {

	public static void main(String[] args) {
		Notepad notepad=new Notepad();
		try {
			notepad.addNote(new Date(), "Привет!");
			notepad.addNote(new Date(), "Все получилось");
		} catch (MyException ex) {
			ex.printStackTrace();
		}
		System.out.println("Notepad!");
		System.out.println(notepad);
	}

}
