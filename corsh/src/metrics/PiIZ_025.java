package metrics;

import functions.AbstractFunction;
import general.MiscFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class PiIZ_025 {
	public static String write(AbstractFunction funct) {
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		int dimension = funct.getDimension();
		
		if(dimension == -1) {
			double[] result10d = new double[30];
			double[] result30d = new double[30];
			
			for(int i = 0; i < 30; i++) {
				result10d[i] = idealZone(funct, 10);
			}
			
			for(int i = 0; i < 30; i++) {
				result30d[i] = idealZone(funct, 30);
			}
			
			Arrays.sort(result10d);
			Arrays.sort(result30d);
			
			result.append("\n Proportion in Ideal Zone \n");
			
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
			
			Arrays.sort(resultArray);
			
			result.append("\n Proportion in Ideal Zone \n");
			
			result.append("Mean IdealZone: " + m.evaluate(resultArray, 0, dimension) + "\n");
			result.append("Max  IdealZone: " + resultArray[dimension] + "\n");
			result.append("Min  IdealZone: " + resultArray[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(resultArray) + "\n");
		}
		
		return result.toString();
	}
	
	private static double idealZone(AbstractFunction funct, int dimension) {
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
			Vector<Double> coordinates = MiscFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);
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
