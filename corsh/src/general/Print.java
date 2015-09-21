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
	
	//Main print function, printing best solution from Simulation's 30 runs
	public static void printBestRuns(String titleAlgorithm, String titleProblem, double[][] values) {
		try {
			PrintWriter writer = new PrintWriter(titleAlgorithm + "_ON_" + titleProblem + "_RAW.txt");
			
			writer.println("Fitness - Violation");
			
			for(int i = 0; i < values.length; i++) {
				writer.println(values[i][0] + " - " + values[i][1]);
			}
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
	
	//New suggested main print function, printing best solution from Simulation's 30 runs
	public static void printBestRunsSuggested(String titleAlgorithm, String titleProblem, Solution[] solutions) {
		try {
			PrintWriter writer = new PrintWriter(titleAlgorithm + "_ON_" + titleProblem + "_RAW.txt");
			
			writer.println("Fitness # Violation # Position"); //# might work better than - for separating numbers when parsing negative numbers
			
			for(int i = 0; i < solutions.length; i++) {
				writer.println(solutions[i].getFitness() + " # " + solutions[i].getViolation() + " # " + solutions[i].getPosition());
			}
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
	
	//Being taken out, in favor of more general output which can be parsed by scripts
	/*
	public static void printResult(String titleAlgorithm, String titleProblem, double meanFit, double meanVio, double maxFit, double maxVio, double minFit, double minVio, double stddevFit, double stddevVio) {
		try {
			PrintWriter writer = new PrintWriter(titleAlgorithm + "_ON_" + titleProblem + "_RESULTS.txt");
			
			writer.println("MEAN FITNESS");
			writer.println(meanFit);
			writer.println("");
			
			writer.println("MAX FITNESS");
			writer.println(maxFit);
			writer.println("");
			
			writer.println("MIN FITNESS");
			writer.println(minFit);
			writer.println("");
			
			writer.println("STDDEV FITNESS");
			writer.println(stddevFit);
			writer.println("");
			writer.println("");
			
			writer.println("MEAN VIOLATION");
			writer.println(meanVio);
			writer.println("");
			
			writer.println("MAX VIOLATION");
			writer.println(maxVio);
			writer.println("");
			
			writer.println("MIN VIOLATION");
			writer.println(minVio);
			writer.println("");
		
			writer.println("STDDEV VIOLATION");
			writer.println(stddevVio);
			writer.println("");
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}*/
	
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
