package chapter6.employee;

import java.util.Calendar;
import java.util.Date;

/**
 * Interface used for get common functionality to entity an employee.
 * 
 * @author јхтырскийёра
 *
 */

public interface IEmployee {
	/**
	 * Recruit employee on work.
	 * 
	 * @param organization - organization name
	 * @param position - position on which recruit the employee
	 * @param salary - salary
	 * @param hiring - date when employee hiring
	 */
	void recruit (String organization, String position, double salary, Date hiring);
	
	/**
	 * Fire the employee. Wherein erases information about organization in which employee works, position, salary.
	 */
	void fire();
	
	/**
	 * Sets time when employee come to work.
	 * @param time - time come to work
	 */
	void comeOnWork(Date time);
	
	/**
	 * Sets time when employee out off work.
	 * @param time - time out off work
	 */
	void offFromWork(Date time);
}
