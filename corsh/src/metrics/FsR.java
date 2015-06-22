package metrics;

import general.RandFunctions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import problems.AbstractProblem;

public class FsR {
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
				result2d[i] = feasibility(funct, 2);
			}
			
			for(int i = 0; i < 30; i++) {
				result10d[i] = feasibility(funct, 10);
			}
			
			for(int i = 0; i < 30; i++) {
				result30d[i] = feasibility(funct, 30);
			}
			
			try {
				PrintWriter writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "FsR_Raw.dat");
				
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
			
			result.append("\nFeasibility Ratio (FsR)\n");
			
			result.append("2D\n");
			result.append("Mean Feasibility: " + m.evaluate(result2d, 0, 30) + "\n");
			result.append("Max  Feasibility: " + result2d[29] + "\n");
			result.append("Min  Feasibility: " + result2d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result2d) + "\n");
			
			result.append("10D\n");
			result.append("Mean Feasibility: " + m.evaluate(result10d, 0, 30) + "\n");
			result.append("Max  Feasibility: " + result10d[29] + "\n");
			result.append("Min  Feasibility: " + result10d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result10d) + "\n");

			result.append("\n30D\n");
			result.append("Mean Feasibility: " + m.evaluate(result30d, 0, 30) + "\n");
			result.append("Max  Feasibility: " + result30d[29] + "\n");
			result.append("Min  Feasibility: " + result30d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result30d) + "\n");
		}
		else {
			double[] resultArray = new double[30];
			
			for(int i = 0; i < 30; i++) {
				resultArray[i] = feasibility(funct, dimension);
			}
			
			try {
				PrintWriter writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "FsR_Raw.dat");

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
			
			result.append("\nFeasibility Ratio (FsR) \n");
			
			result.append("Mean Feasibility: " + m.evaluate(resultArray, 0, dimension) + "\n");
			result.append("Max  Feasibility: " + resultArray[29] + "\n");
			result.append("Min  Feasibility: " + resultArray[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(resultArray) + "\n");
		}
		
		return result.toString();
	}
	
	public static double feasibility(AbstractProblem funct, int dimension) {
		double result;
		double counter = 0.0;
		int size = dimension * 1000;

		for(int i = 0; i < size; i++) {
			Vector<Double> coordinates = RandFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);
			double violation = (double) funct.violation(coordinates);
			if(violation <= 0.0000000001) {
				counter++;
			}
		}	

		result = counter/size;
		
		return result;
	}
}
