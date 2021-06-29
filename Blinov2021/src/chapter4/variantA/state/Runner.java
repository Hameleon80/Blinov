package chapter4.variantA.state;

import java.io.IOException;

import chapter4.variantA.exception.MyException;
import chapter4.variantA.state.entity.State;

public class Runner {
	public static void main(String[] args) {
		State state=null;
		try {
			state=Util.getStateFromFile("src/chapter4/variantA/state/state.txt");
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		System.out.println(state);
	}
}
