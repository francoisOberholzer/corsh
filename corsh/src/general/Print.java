package general;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

public class Print {
	//Handles all printing to files
	ArrayList<Vector<Double>> positions = new ArrayList<Vector<Double>>();
	ArrayList<Double> fitnesses = new ArrayList<Double>();
	ArrayList<Double> violations = new ArrayList<Double>();
	
	//Main print function, printing best solutions from Simulation's 30 runs
	public static void printBestRuns(String titleAlgorithm, String titleProblem, Solution[] solutions) {
		try {
			PrintWriter writer = new PrintWriter(titleAlgorithm + "_ON_" + titleProblem + "_RAW.txt");
			
			writer.println("Fitness : Violation : Position : Miscellaneous");
			
			for(int i = 0; i < solutions.length; i++) {
				writer.println(solutions[i].getFitness() + " : " + solutions[i].getViolation() + " : " + solutions[i].getPosition() + " : " + solutions[i].getMiscellaneous());
			}
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
	
	//DE Progress for Constrained and Unconstrained functions
	public void printDEProgress(Vector<Double> _position, double _fitness, double _violation) {
		positions.add(_position);
		fitnesses.add(_fitness);
		violations.add(_violation);
	}
	public void printUnconstrainedDEProgress(Vector<Double> _position, double _fitness) {
		positions.add(_position);
		fitnesses.add(_fitness);
	}
	public void printDEProgressFinal(String titleAlgorithm, String titleProblem) {
		try {
			PrintWriter writer = new PrintWriter(titleAlgorithm + "_ON_" + titleProblem + "_DE_PROGRESS.txt");
			
			writer.println("Position - Fitness - Violation");
			
			for(int i = 0; i < positions.size(); i++) {
				writer.println(positions.get(i) + " - " + fitnesses.get(i) + " - " + violations.get(i));
			}
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
	public void printUnconstrainedDEProgressFinal(String titleAlgorithm, String titleProblem) {
		try {
			PrintWriter writer = new PrintWriter(titleAlgorithm + "_ON_" + titleProblem + "_DE_PROGRESS.txt");

			writer.println("Position - Fitness");

			for(int i = 0; i < positions.size(); i++) {
				writer.println(positions.get(i) + " - " + fitnesses.get(i) );
			}

			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
	
	//For drawing FVC graphs, called by Start_Metrics_FVCGraphs
	public static void printFVC(String titleProblem, double[][] values) {
		try {
			PrintWriter writer = new PrintWriter("FVC_" + titleProblem + ".txt");
			
			for(int i = 0; i < values[1].length; i++) {	
				writer.println(values[0][i] + " " + values[1][i]);
			}
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
	
	//For drawing Convergence graphs, called by Start_DE_Convergence
	public static void printConvergenceGraphs(String titleProblem, double[][] values, int num) {
		try {
			PrintWriter writer = new PrintWriter(titleProblem + "_CONVERGENCE_" + num + ".dat");
			
			for(int i = 0; i < values.length; i++) {
				writer.println(values[i][0] + " " + values[i][1]);
			}
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
}
