package algorithms.metrics;

import general.RandFunctions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import algorithms.AbstractAlgorithm;

import problems.AbstractProblem;

public class MET_PiIZ_025 extends AbstractAlgorithm {
	public double[] run(AbstractProblem funct, int maxEvaluations) {
		double counter = 0.0;
		double borderViolation;
		double borderFitness;
		double minFit;
		double maxFit;
		double maxViol;
		int dimension = funct.getDimension();
		int size = dimension * 1000;
		ArrayList<Double> fitnesses = new ArrayList<>(size);
		ArrayList<Double> violations = new ArrayList<>(size);

		for(int i = 0; i < size; i++) {
			Vector<Double> coordinates = RandFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);
			fitnesses.add((double) funct.fitness(coordinates));
			violations.add((double) funct.violation(coordinates));
		}	
		
		Collections.sort(fitnesses);
		Collections.sort(violations);
		
		minFit = fitnesses.get(0);
		maxFit = fitnesses.get(size-1);
		maxViol = violations.get(size-1);
		
		borderFitness = minFit + ((maxFit - minFit) * 0.5);
		borderViolation = maxViol * 0.1;
		
		for(int i = 0; i < size; i++) {
			if((fitnesses.get(i) < borderFitness) && (violations.get(i) < borderViolation)) {
				counter++;
			}
		}	
		
		double[] result = new double[2];
		
		result[0] = counter/size;
		result[1] = 0.0;
		
		return result;
	}
	
	public String getName() { 
		return "PiIZ025";
	}
}
