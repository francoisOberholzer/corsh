package metrics;

import functions.AbstractFunction;
import general.MiscFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class PiIZ_001 {
	public static String write(AbstractFunction funct, double min, double max) {
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		
		double[] result10d = new double[30];
		double[] result30d = new double[30];
		
		for(int i = 0; i < 30; i++) {
			result10d[i] = idealZone(funct, min, max, 10);
		}
		
		for(int i = 0; i < 30; i++) {
			result30d[i] = idealZone(funct, min, max, 30);
		}
		
		Arrays.sort(result10d);
		Arrays.sort(result30d);
		
		result.append("\nProportion in Ideal Zone 0.01 \n");
		
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

		return result.toString();
	}
	
	private static double idealZone(AbstractFunction funct, double min, double max, int dimension) {
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
			Vector<Double> coordinates = MiscFunctions.getCoordinates(min, max, dimension);
			fitnesses.add((double) funct.f(coordinates));
			violations.add((double) funct.violation(coordinates));
		}	
		
		Collections.sort(fitnesses);
		Collections.sort(violations);
		
		minFit = fitnesses.get(0);
		maxFit = fitnesses.get(size-1);
		maxViol = violations.get(size-1);
		
		borderFitness = minFit + ((maxFit - minFit) * 0.1);
		borderViolation = maxViol * 0.1;
		
		for(int i = 0; i < size; i++) {
			if((fitnesses.get(i) < borderFitness) && (violations.get(i) < borderViolation)) {
				counter++;
			}
		}	
		
		result = counter/size;
		
		return result;
	}
}
