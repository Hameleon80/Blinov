package chapter6.employee;

public class Runner {

	public static void main(String[] args) {
		Engineer pupkin=new Engineer("Василий Пупкин");
		pupkin.setOrganization("SpaceX");
		pupkin.setPosition("software developer");
		pupkin.setSalary(60000);
		System.out.println(pupkin);
		pupkin.fire();
		System.out.println(pupkin);
	}

}
