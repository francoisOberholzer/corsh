package algorithms.metrics;

import general.RandFunctions;
import general.Solution;

import java.util.Vector;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

import algorithms.AbstractAlgorithm;

import problems.AbstractProblem;

public class MET_FVC extends AbstractAlgorithm {
	public Solution run(AbstractProblem funct, int maxEvaluations) {
		int dimension = funct.getDimension();
		int size = dimension * 1000;
			
		double[][] data = new double[2][size];
		
		for(int i = 0; i < size; i++) {
			Vector<Double> coordinates = RandFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);

			double resFit = (double) funct.fitness(coordinates);
			double resVal = (double) funct.violation(coordinates);

			data[0][i] = resFit;
			data[1][i] = resVal;
		}

		Solution result = new Solution(spearmansCorrelation(data[0], data[1]));
		
		return result;
	}
	
	public double[][] runGraph(AbstractProblem funct) {
		int dimension = funct.getDimension();
		int size = dimension * 1000;
			
		double[][] data = new double[2][size];
		
		for(int i = 0; i < size; i++) {
			Vector<Double> coordinates = RandFunctions.getCoordinates(funct.getDomainsMin(), funct.getDomainsMax(), dimension);

			double resFit = (double) funct.fitness(coordinates);
			double resVal = (double) funct.violation(coordinates);

			data[0][i] = resFit;
			data[1][i] = resVal;
		}
		
		return data;
	}

	private static double spearmansCorrelation(double[] xArray, double[] yArray) {
		SpearmansCorrelation sc = new SpearmansCorrelation();
		return sc.correlation(xArray, yArray);
	}
	
	public String getName() { 
		return "FVC";
	}
}

