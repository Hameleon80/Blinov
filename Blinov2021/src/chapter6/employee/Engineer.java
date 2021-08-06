package chapter6.employee;

import java.util.ArrayList;
import java.util.Date;


/**
 * Class describes base functionality for engineer.
 * @author јхтырскийёра
 *
 */
public class Engineer implements IEmployee {
	
	private String name;
	private String organization;
	private String position;
	private double salary;
	private Date hiring;
	private Date fire;
	private ArrayList<Date> onWorkTime;
	private ArrayList<Date> outWorkTime;
	
	//==================== Constructors ====================
	public Engineer(String name) {
		this.name=name;
	}
	
	public Engineer(String name, String organization, String position, double salary, Date hiring) {
		this.name=name;
		this.organization=organization;
		this.position=position;
		this.salary=salary;
		this.hiring=hiring;
	}
	
	//==================== Getters and setters ====================
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Date getHiring() {
		return hiring;
	}

	public void setHiring(Date hiring) {
		this.hiring = hiring;
	}

	public Date getFire() {
		return fire;
	}

	public void setFire(Date fire) {
		this.fire = fire;
	}

	//==================== Overridden methods ====================
	@Override
	public void recruit(String organization, String position, double salary, Date hiring) {
		this.organization=organization;
		this.position=position;
		this.salary=salary;
		this.hiring=hiring;
	}
	
	@Override
	public void fire() {
		this.organization=null;
		this.position=null;
		this.salary=0.0;
		this.fire=new Date();
	}

	@Override
	public void comeOnWork(Date time) {
		this.onWorkTime.add(time);
	}

	@Override
	public void offFromWork(Date time) {
		this.outWorkTime.add(time);
	}
	
	@Override
	public String toString() {
		StringBuilder result=new StringBuilder();
		result.append("Name: ").append(this.name).append("\n");
		result.append("Work organization: ").append(this.organization).append("\n");
		result.append("Position: ").append(this.position).append("\n");
		result.append("Salary: ").append(this.salary).append("\n");
		return result.toString();
	}
}
