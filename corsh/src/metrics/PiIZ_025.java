package metrics;

import general.RandFunctions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import problems.AbstractProblem;

public class PiIZ_025 {
	public static String write(AbstractProblem funct, int id) {
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		int dimension = funct.getDimension();
		
		if(dimension == -1) {
			double[] result2d = new double[30];
			double[] result10d = new double[30];
			double[] result30d = new double[30];
			
			for(int i = 0; i < 30; i++) {
				result2d[i] = idealZone(funct, 2);
			}
			
			for(int i = 0; i < 30; i++) {
				result10d[i] = idealZone(funct, 10);
			}
			
			for(int i = 0; i < 30; i++) {
				result30d[i] = idealZone(funct, 30);
			}
			
			try {
				PrintWriter writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "PilZ025_Raw.dat");
				
				writer.println("Raw 2D");
				for(int i = 0; i < 30; i++) {
					writer.println(result2d[i]);
				}
				writer.println("Raw 10D");
				for(int i = 0; i < 30; i++) {
					writer.println(result10d[i]);
				}
				writer.println("Raw 30D");
				for(int i = 0; i < 30; i++) {
					writer.println(result30d[i]);
				}
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error RAW file not found.");
			}
			
			Arrays.sort(result2d);
			Arrays.sort(result10d);
			Arrays.sort(result30d);
			
			result.append("\nProportion in Ideal Zone 0.25 \n");
			
			result.append("2D\n");
			result.append("Mean IdealZone: " + m.evaluate(result2d, 0, 30) + "\n");
			result.append("Max  IdealZone: " + result2d[29] + "\n");
			result.append("Min  IdealZone: " + result2d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result2d) + "\n");
			
			result.append("10D\n");
			result.append("Mean IdealZone: " + m.evaluate(result10d, 0, 30) + "\n");
			result.append("Max  IdealZone: " + result10d[29] + "\n");
			result.append("Min  IdealZone: " + result10d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result10d) + "\n");

			result.append("\n30D\n");
			result.append("Mean IdealZone: " + m.evaluate(result30d, 0, 30) + "\n");
			result.append("Max  IdealZone: " + result30d[29] + "\n");
			result.append("Min  IdealZone: " + result30d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result30d) + "\n");
		}
		else {
			double[] resultArray = new double[30];
			
			for(int i = 0; i < 30; i++) {
				resultArray[i] = idealZone(funct, dimension);
			}
			
			try {
				PrintWriter writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "PilZ025_Raw.dat");

				writer.println("Raw " + dimension + "D");
				for(int i = 0; i < 30; i++) {
					writer.println(resultArray[i]);
				}
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error RAW file not found.");
			}
			
			Arrays.sort(resultArray);
			
			result.append("\nProportion in Ideal Zone 0.25 \n");
			
			result.append("Mean IdealZone: " + m.evaluate(resultArray, 0, dimension) + "\n");
			result.append("Max  IdealZone: " + resultArray[29] + "\n");
			result.append("Min  IdealZone: " + resultArray[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(resultArray) + "\n");
		}
		
		return result.toString();
	}
	
	private static double idealZone(AbstractProblem funct, int dimension) {
		double result;
		double counter = 0.0;
		double borderViolation;
		double borderFitness;
		double minFit;
		double maxFit;
		double maxViol;
		
		int size = dimension * 1000;
		ArrayList<Double> fitnesses = new ArrayList<>(size);
		ArrayList<Double> violations = new ArrayList<>(size);

		for(int i = 0; i < size; i++) {
			Vector<Double> coordinates = RandFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);
			fitnesses.add((double) funct.f(coordinates));
			violations.add((double) funct.violation(coordinates));
		}	
		
		Collections.sort(fitnesses);
		Collections.sort(violations);
		
		minFit = fitnesses.get(0);
		maxFit = fitnesses.get(size-1);
		maxViol = violations.get(size-1);
		
		borderFitness = minFit + ((maxFit - minFit) * 0.5);
		borderViolation = maxViol * 0.5;
		
		for(int i = 0; i < size; i++) {
			if((fitnesses.get(i) < borderFitness) && (violations.get(i) < borderViolation)) {
				counter++;
			}
		}	
		
		result = counter/size;
		
		return result;
	}
}
