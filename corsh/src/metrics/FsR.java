package metrics;

import functions.AbstractFunction;
import general.MiscFunctions;

import java.util.Arrays;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class FsR {
	public static String write(AbstractFunction funct) {
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		int dimension = funct.getDimension();
		
		if(dimension == -1) {
			double[] result10d = new double[30];
			double[] result30d = new double[30];
			
			for(int i = 0; i < 30; i++) {
				result10d[i] = feasibility(funct, 10);
			}
			
			for(int i = 0; i < 30; i++) {
				result30d[i] = feasibility(funct, 30);
			}
			
			Arrays.sort(result10d);
			Arrays.sort(result30d);
			
			result.append("\nFeasibility Ratio \n");
			
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
			
			Arrays.sort(resultArray);
			
			result.append("\nFeasibility Ratio \n");
			
			result.append("Mean Feasibility: " + m.evaluate(resultArray, 0, dimension) + "\n");
			result.append("Max  Feasibility: " + resultArray[dimension] + "\n");
			result.append("Min  Feasibility: " + resultArray[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(resultArray) + "\n");
		}
		
		return result.toString();
	}
	
	private static double feasibility(AbstractFunction funct, int dimension) {
		double result;
		double counter = 0.0;
		int size = dimension * 1000;

		for(int i = 0; i < size; i++) {
			Vector<Double> coordinates = MiscFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);
			double violation = (double) funct.violation(coordinates);
			if(violation <= 0.0000000001) {
				counter++;
			}
		}	

		result = counter/size;
		
		return result;
	}
}
