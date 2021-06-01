package chapter3.variantA.entity;

import java.util.ArrayList;

/**
 * @author јхтырскийёра
 *
 * Class describes Abiturient.
 */
public class Abiturient extends Person {
	public ArrayList<Integer> grade;
	
	//=========== Constructors ==============
	public Abiturient() {
		super();
	}
	
	public Abiturient(int id, String lastName, String firstName, String middleName, String adress, String phoneNumber, ArrayList<Integer> grade) {
		super(id, lastName, firstName, middleName, adress, phoneNumber);
		this.grade=grade;
	}
	
	//=========== Getters and setters ===========
	public ArrayList<Integer> getGrade() {
		return grade;
	}

	public void setGrade(ArrayList<Integer> grade) {
		this.grade = grade;
	}
	
	//=========== Methods ===========
	
	//method return summ of grade
	public int getSumm() {
		if (grade==null || grade.size()==0) {
			return 0;
		}
		int summ=0;
		for(Integer arrElement: grade) {
			summ+=arrElement;
		}
		return summ;
	}
	
	//determines has abiturient bad grades 
	public boolean isBadGrade() {
		if (grade==null || grade.size()==0) {
			return false;
		}
		for(Integer arrElement: grade) {
			if(arrElement<=5) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"Grade: " + grade;
	}
	
}
