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
	
	public static void printRaw(String titleAlgorithm, String titleProblem, double[][] values) {
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
	
	public static void printResult(String titleAlgorithm, String titleProblem, double mean, double max, double min, double stddev) {
		try {
			PrintWriter writer = new PrintWriter(titleAlgorithm + "_ON_" + titleProblem + "_RESULTS.txt");
			
			writer.println("MEAN");
			writer.println("MAX");
			writer.println("MIN");
			writer.println("STDDEV");
			
			writer.println("");
			
			writer.println(mean);
			writer.println(max);
			writer.println(min);
			writer.println(stddev);
			
			writer.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Error file not found.");
			return;
		}
	}
	
	public void printDEProgress(Vector<Double> _position, double _fitness, double _violation) {
		positions.add(_position);
		fitnesses.add(_fitness);
		violations.add(_violation);
	}
	
	public void printDEProgressFinal(String titleAlgorithm, String titleProblem) {
		try {
			PrintWriter writer = new PrintWriter(titleAlgorithm + "_ON_" + titleProblem + "_DE_PROGRESS.txt");
			
			writer.println("Fitness - Violation - Position");
			
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
