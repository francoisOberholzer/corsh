package algorithms.metrics;

import general.RandFunctions;
import java.util.Vector;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

import algorithms.AbstractAlgorithm;

import problems.AbstractProblem;

public class MET_FVC extends AbstractAlgorithm {
	public double[] run(AbstractProblem funct, int maxEvaluations) {
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
		
		double[] result = new double[2];
		
		result[0] = spearmansCorrelation(data[0], data[1]);
		result[1] = 0.0;

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

