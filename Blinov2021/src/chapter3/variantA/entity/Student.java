package chapter3.variantA.entity;

import java.util.Date;

import chapter3.variantA.enums.Course;
import chapter3.variantA.enums.Faculty;
import chapter3.variantA.enums.Groupe2021;
/**
 * Entity that describes student.
 * 
 * @author јхтырский ёрий
 *
 */
public class Student extends Person {

	private Date birthday;
	private Faculty faculty;
	private Course course;
	private Groupe2021 groupe;
	
	//constructors
	public Student() {
		super();
	}
	
	public Student(int id, String lastName, String firstName, String middleName, String adres, String phoneNumber, 
			Date birthday, Faculty faculty, Course course, Groupe2021 groupe) {
		super(id, lastName, firstName, middleName, adres, phoneNumber);
		
		this.birthday=birthday;
		this.faculty=faculty;
		this.course=course;
		this.groupe=groupe;
	}

	//getters and setters
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Groupe2021 getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe2021 groupe) {
		this.groupe = groupe;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nfaculty: " + faculty+
				"\ncourse: " + course+
				"\ngroupe: " + groupe;
	}
}
