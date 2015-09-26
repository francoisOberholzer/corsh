package algorithms.cht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import algorithms.AbstractAlgorithm;
import problems.AbstractProblem;
import general.Print;
import general.RandFunctions;
import general.Solution;

public class DE_3_Penalty_Max extends AbstractAlgorithm {
	private static double CR = 0.5; //Crossover Constant
	private static double F = 0.5; //Scaling Factor
	private static int POPSIZE = 100; //Pop Size
	private static double ADDPENALTYCOEFF = 1; //Penalty Coefficient
	
	public Solution run(AbstractProblem funct, int maxEvaluations) {
		Vector<Double> bestPosition = null;
		double bestFitness = Double.MAX_VALUE;
		double bestViolation = 0;
		int currentEvaluations = 0;
		int evaluationsTillNextPrint = POPSIZE;
		int dimension = funct.getDimension();
		maxEvaluations = maxEvaluations * dimension;
		Print print = new Print();
		
		//Initialize Population
		ArrayList<Vector<Double>> population = new ArrayList<Vector<Double>>();
		ArrayList<Vector<Double>> newPopulation = new ArrayList<Vector<Double>>();
		for(int i = 0; i < POPSIZE; i++) {
			population.add(new Vector<Double>());
			for(int j = 0; j < dimension; j++) {
				population.get(i).add(RandFunctions.getRandom(funct.getDomainsMin()[j], funct.getDomainsMax()[j]));
			}
		}
		
		//DE
		while(currentEvaluations < maxEvaluations) { //Until stopping condition is met
			for(int i = 0; i < POPSIZE; i++) { //For each individual in Pop
				//Mutation and Crossover
				int[] randomIndividuals = getRandomIndividuals(i);
				Vector<Double> parent = population.get(i);
				Vector<Double> r1 = population.get(randomIndividuals[0]);
				Vector<Double> r2 = population.get(randomIndividuals[1]);
				Vector<Double> r3 = population.get(randomIndividuals[2]);	
				Vector<Double> child = recombine(parent, r1, r2, r3, dimension, funct.getDomainsMin(), funct.getDomainsMax());
				
				//Replacement
				double[] maxViolation = funct.violationArray(child);
				Arrays.sort(maxViolation);
				double childFitness = funct.fitness(child) + (maxViolation[maxViolation.length-1] * ADDPENALTYCOEFF);
				currentEvaluations++;
				maxViolation = funct.violationArray(parent);
				Arrays.sort(maxViolation);
				double parentFitness = funct.fitness(parent) + (maxViolation[maxViolation.length-1] * ADDPENALTYCOEFF);
				currentEvaluations++;

				if(childFitness > parentFitness) {
					newPopulation.add(parent);
					
					if(funct.fitness(parent) < bestFitness) {
						bestFitness = funct.fitness(parent);
						bestViolation = funct.violation(parent);
						bestPosition = parent;
						currentEvaluations++;
						currentEvaluations++;
					}
				}
				else {
					newPopulation.add(child);
					
					if(funct.fitness(child) < bestFitness) {
						bestFitness = funct.fitness(child);
						bestViolation = funct.violation(child);
						bestPosition = child;
						currentEvaluations++;
						currentEvaluations++;
					}
				}
				
				if(currentEvaluations > evaluationsTillNextPrint) {
					evaluationsTillNextPrint += POPSIZE;
					print.printDEProgress(bestPosition, bestFitness, bestViolation);
				}
			}
			
			//Move over to next generation
			population = newPopulation;
			newPopulation = new ArrayList<Vector<Double>>(POPSIZE);
		}
		
		Solution result = new Solution(bestFitness, bestViolation, bestPosition);
		
		return result;
	}
	
	//Recombine
	private static Vector<Double> recombine(Vector<Double> parent, Vector<Double> ran1, Vector<Double> ran2, Vector<Double> ran3, int dimension, double[] min, double[] max) {
		int jrandom = (int) RandFunctions.getRandom(0,dimension-1);
		Vector<Double> child = new Vector<Double>(dimension);

		for(int j = 0; j < dimension; j++) {
			if((RandFunctions.getRandom(0,1) < CR) || (j == jrandom)) {
				double v = ran3.get(j) + (F * (ran1.get(j) - ran2.get(j)));
				
				if(v > max[j]) {
					v = (parent.get(j) + max[j]) / 2;
				}
				else if(v < min[j]) {
					v = (parent.get(j) + min[j]) / 2;
				}
				
				child.add(v);
			}
			else {
				child.add(parent.get(j));
			}
		}
		
		return child;
	}
	
	//Pick 3 random others in population
	private static int[] getRandomIndividuals(int parent) {
		int[] result = new int[]{0, 0, 0};
		
		result[0] = (int) RandFunctions.getRandom(0, POPSIZE);
		result[1] = (int) RandFunctions.getRandom(0, POPSIZE);
		result[2] = (int) RandFunctions.getRandom(0, POPSIZE);
		
		while(result[0] == parent) {
			result[0] = (int) RandFunctions.getRandom(0, POPSIZE);
		}
		
		while((result[1] == result[0]) || (result[1] == parent)) {
			result[1] = (int) RandFunctions.getRandom(0, POPSIZE);
		}
		
		while((result[2] == result[0]) || (result[2] == result[1]) || (result[2] == parent)) {
			result[2] = (int) RandFunctions.getRandom(0, POPSIZE);
		}
		
		return result;
	}
	
	//Get Name
	public String getName() { 
		return "DE_PenaltyMax";
	}
}