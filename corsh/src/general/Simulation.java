package general;

import java.util.Arrays;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import problems.AbstractProblem;
import algorithms.AbstractAlgorithm;

public class Simulation {
	private AbstractAlgorithm[] algorithms;
	private AbstractProblem[] problems;
	private int maxEvaluations;
	
	//Constructor
	public Simulation(AbstractAlgorithm[] _algorithms, AbstractProblem[] _problems, int _maxEvaluations) {
		algorithms = _algorithms;
		problems = _problems;
		maxEvaluations = _maxEvaluations;
	}
	
	//Run all algorithms on all problems
	public void run() {
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		
		for(int a = 0; a < algorithms.length; a++) { //For every algorithm
			for(int p = 0; p < problems.length; p++) { //For every problem
				double[][] results = new double[30][2]; //Fitness and Violation
				double[] resultsFitOnly = new double[30]; //Only Fitness
				
				for(int i = 0; i < 30; i++) { //For 30 times
					results[i] = algorithms[a].run(problems[p], maxEvaluations);
					resultsFitOnly[i] = results[i][0];
				}
				
				//Print
				Print.printRaw(algorithms[a].getName(), problems[p].getName(), results);	
				Arrays.sort(resultsFitOnly);
				Print.printResult(algorithms[a].getName(), problems[p].getName(), m.evaluate(resultsFitOnly, 0, 30), resultsFitOnly[29], resultsFitOnly[0], std.evaluate(resultsFitOnly));
			}
		}
	}
}