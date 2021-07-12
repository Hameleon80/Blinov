package chapter5.variantA;

import java.util.Date;

import chapter5.exception.MyException;
import chapter5.variantA.notepad.Notepad;

public class Runner {

	public static void main(String[] args) {
		Notepad notepad=new Notepad();
		try {
			notepad.addNote(new Date(), "������!");
			notepad.addNote(new Date(), "��� ����������");
		} catch (MyException ex) {
			ex.printStackTrace();
		}
		System.out.println("Notepad!");
		System.out.println(notepad);
	}

}
