package general;

import problems.*;
import algorithms.*;

public class StartDEConvergenceTest {
	public static void main(String[] args) {	
		//Setup Simulation
		AbstractAlgorithm algorithm = new DE_Convergence();
		AbstractProblem[] problems = getProblemsList();

		//Run Simulation
		for(int i = 0; i < 18; i++) {
			System.out.println("Starting with run " + i + ".");
			algorithm.run(problems[i], 10000);
		}
	}
	
	//Initializes list of problems to use
	private static AbstractProblem[] getProblemsList() {
		AbstractProblem[] problems = null;
		
		problems = new AbstractProblem[18];
		problems[0] = new C01_2D();
		problems[1] = new C02_2D();
		problems[2] = new C03_2D();
		problems[3] = new C04_2D();
		problems[4] = new C05_2D();
		problems[5] = new C06_2D();
		problems[6] = new C07_2D();
		problems[7] = new C08_2D();
		problems[8] = new C09_2D();
		problems[9] = new C10_2D();
		problems[10] = new C11_2D();
		problems[11] = new C12_2D();
		problems[12] = new C13_2D();
		problems[13] = new C14_2D();
		problems[14] = new C15_2D();
		problems[15] = new C16_2D();
		problems[16] = new C17_2D();
		problems[17] = new C18_2D();
		
		return problems;
	}
}
