package general;

//import org.apache.commons.math3.stat.descriptive.moment.Mean;
//import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
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
		for(int a = 0; a < algorithms.length; a++) { //For every algorithm
			for(int p = 0; p < problems.length; p++) { //For every problem
				Solution[] results = new Solution[30];
				
				for(int i = 0; i < 30; i++) { //For 30 times
					results[i] = algorithms[a].run(problems[p], maxEvaluations);
				}
				
				//Print
				Print.printBestRuns(algorithms[a].getName(), problems[p].getName(), results);	
			}
		}
	}
}