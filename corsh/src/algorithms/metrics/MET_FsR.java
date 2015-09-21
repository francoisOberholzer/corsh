package algorithms.metrics;

import general.RandFunctions;
import java.util.Vector;

import algorithms.AbstractAlgorithm;

import problems.AbstractProblem;

public class MET_FsR extends AbstractAlgorithm {
	public double[] run(AbstractProblem funct, int maxEvaluations) {
		double counter = 0.0;
		int dimension = funct.getDimension();
		int size = dimension * 1000;

		for(int i = 0; i < size; i++) {
			Vector<Double> coordinates = RandFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);
			double violation = (double) funct.violation(coordinates);
			if(violation <= 0.0000000001) {
				counter++;
			}
		}	

		double[] result = new double[2];
		
		result[0] = counter/size;
		result[1] = 0.0;
		
		return result;
	}
	
	public String getName() { 
		return "FsR";
	}
}
