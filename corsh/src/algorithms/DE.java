package algorithms;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import problems.AbstractProblem;

import general.RandFunctions;

public class DE {
	private static double CR = 0.5; //Crossover Constant
	private static double F = 0.5; //Scaling Factor
	private static int POPSIZE = 100; //Pop Size
	private static double ADDPENALTYCOEFF = 1; //AdaptivePenalty Coefficient
	
	public static String write(AbstractProblem funct, int cht, int id, int maxFunctionEvaluations) { //ID: 0 - None, 1 - DeathPenalty, 2 - AdaptivePenalty, 3 - PieceWise
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		int dimension = funct.getDimension();
		
		if(dimension == -1) { //Any Dimension
			double[] result2d = new double[30];
			double[] result10d = new double[30];
			double[] result30d = new double[30];
			
			for(int i = 0; i < 30; i++) {
				result2d[i] = evolution(funct, 2, cht, maxFunctionEvaluations);
			}
			
			for(int i = 0; i < 30; i++) {
				result10d[i] = evolution(funct, 10, cht, maxFunctionEvaluations);
			}
			
			for(int i = 0; i < 30; i++) {
				result30d[i] = evolution(funct, 30, cht, maxFunctionEvaluations);
			}
			
			try {
				PrintWriter writer;
				
				if(cht == 1) {
					writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "DE(DP)_Raw.dat");
				}
				else if(cht == 2) {
					writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "DE(Pen)_Raw.dat");
				}
				else if(cht == 3) {
					writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "DE(PW)_Raw.dat");
				}		
				else {
					writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "DE(None)_Raw.dat");
				}
				
				writer.println("Raw 2D");
				for(int i = 0; i < 30; i++) {
					writer.println(result2d[i]);
				}
				writer.println("Raw 10D");
				for(int i = 0; i < 30; i++) {
					writer.println(result10d[i]);
				}
				writer.println("Raw 30D");
				for(int i = 0; i < 30; i++) {
					writer.println(result30d[i]);
				}
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error RAW file not found.");
			}
			
			Arrays.sort(result2d);
			Arrays.sort(result10d);
			Arrays.sort(result30d);
			
			result.append("2D\n");
			result.append("Mean Fitness: " + m.evaluate(result2d, 0, 30) + "\n");
			result.append("Max  Fitness: " + result2d[29] + "\n");
			result.append("Min  Fitness: " + result2d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result2d) + "\n");
			
			result.append("10D\n");
			result.append("Mean Fitness: " + m.evaluate(result10d, 0, 30) + "\n");
			result.append("Max  Fitness: " + result10d[29] + "\n");
			result.append("Min  Fitness: " + result10d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result10d) + "\n");

			result.append("\n30D\n");
			result.append("Mean Fitness: " + m.evaluate(result30d, 0, 30) + "\n");
			result.append("Max  Fitness: " + result30d[29] + "\n");
			result.append("Min  Fitness: " + result30d[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(result30d) + "\n");
		}
		else {
			double[] resultArray = new double[30];
			
			for(int i = 0; i < 30; i++) {
				resultArray[i] = evolution(funct, dimension, cht, maxFunctionEvaluations);
			}
			
			try {
				PrintWriter writer;
				
				if(cht == 1) {
					writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "DE(DP)_Raw.dat");
				}
				else if(cht == 2) {
					writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "DE(Pen)_Raw.dat");
				}
				else if(cht == 3) {
					writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "DE(PW)_Raw.dat");
				}
				else {
					writer = new PrintWriter((id+1) + "_" + dimension + "D_" + "DE(None)_Raw.dat");
				}
				
				writer.println("Raw " + dimension + "D");
				for(int i = 0; i < 30; i++) {
					writer.println(resultArray[i]);
				}
				
				writer.close();
			}
			catch (FileNotFoundException fnfe) {
				System.out.println("Error RAW file not found.");
			}
			
			Arrays.sort(resultArray);
			
			result.append("Mean Fitness: " + m.evaluate(resultArray, 0, dimension) + "\n");
			result.append("Max  Fitness: " + resultArray[dimension] + "\n");
			result.append("Min  Fitness: " + resultArray[0] + "\n");
			result.append("Standard Deviation: " + std.evaluate(resultArray) + "\n");
		}
		
		return result.toString();
	}
	
	//Actual Function
	private static double evolution(AbstractProblem funct, int dimension, int cht, int maxFunctionEvaluations) {
		double bestFitness = Double.MAX_VALUE;
		int currentEvaluations = 0;
		maxFunctionEvaluations = maxFunctionEvaluations * dimension;
		
		//Initialize Population
		ArrayList<Vector<Double>> population = new ArrayList<Vector<Double>>();
		ArrayList<Vector<Double>> newPopulation = new ArrayList<Vector<Double>>();
		for(int i = 0; i < POPSIZE; i++) {
			population.add(new Vector<Double>());
			for(int j = 0; j < dimension; j++) {
				population.get(i).add(RandFunctions.getRandom(funct.getDomainsMin()[j], funct.getDomainsMax()[j]));
			}
			if(cht == 1) { //For DeathPenalty, initialize to valid start positions
				boolean flag = true;
				while(flag) {
					population.get(i).clear();
					for(int j = 0; j < dimension; j++) {
						population.get(i).add(RandFunctions.getRandom(funct.getDomainsMin()[j], funct.getDomainsMax()[j]));
					}
					
					if(funct.violation(population.get(i)) == 0) {
						flag = false;
					}
					
					currentEvaluations++;
					if(currentEvaluations > maxFunctionEvaluations) {
						flag = false;
					}
				}
			}
		}
		
		//DE
		while(currentEvaluations < maxFunctionEvaluations) { //Until stopping condition is met
			for(int i = 0; i < POPSIZE; i++) { //For each individual in Pop
				//Different Constraint Handling Techniques
				if(cht == 0) { //None
					//Mutation and Crossover
					int[] randomIndividuals = getRandomIndividuals(i);
					Vector<Double> parent = population.get(i);
					Vector<Double> r1 = population.get(randomIndividuals[0]);
					Vector<Double> r2 = population.get(randomIndividuals[1]);
					Vector<Double> r3 = population.get(randomIndividuals[2]);	
					Vector<Double> child = recombine(parent, r1, r2, r3, dimension, funct.getDomainsMin(), funct.getDomainsMax());
					
					//Replacement
					double childFitness = funct.f(child);
					currentEvaluations++;
					double parentFitness = funct.f(parent);
					currentEvaluations++;

					if(childFitness > parentFitness) {
						newPopulation.add(parent);
						
						if(parentFitness < bestFitness) {
							bestFitness = parentFitness;
						}
					}
					else {
						newPopulation.add(child);
						
						if(childFitness < bestFitness) {
							bestFitness = childFitness;
						}
					}
				}
				else if(cht == 1) { //DeathPenalty
					//Mutation and Crossover
					int[] randomIndividuals = getRandomIndividuals(i);
					Vector<Double> parent = population.get(i);
					Vector<Double> r1 = population.get(randomIndividuals[0]);
					Vector<Double> r2 = population.get(randomIndividuals[1]);
					Vector<Double> r3 = population.get(randomIndividuals[2]);	
					Vector<Double> child = recombine(parent, r1, r2, r3, dimension, funct.getDomainsMin(), funct.getDomainsMax());
					
					if(funct.violation(child) == 0) {
						//Replacement
						double childFitness = funct.f(child);
						currentEvaluations++;
						double parentFitness = funct.f(parent);
						currentEvaluations++;
						
						if(childFitness > parentFitness) {
							newPopulation.add(parent);
							
							if(parentFitness < bestFitness) {
								bestFitness = parentFitness;
							}
						}
						else {
							newPopulation.add(child);
							
							if(childFitness < bestFitness) {
								bestFitness = childFitness;
							}
						}
					}
					else {
						double parentFitness = funct.f(parent);
						currentEvaluations++;
						
						newPopulation.add(parent);
					
						if(parentFitness < bestFitness) {
							bestFitness = parentFitness;
						}
					}
					
					
				}
				else if(cht == 2) { //AdaptivePenalty
					//Mutation and Crossover
					int[] randomIndividuals = getRandomIndividuals(i);
					Vector<Double> parent = population.get(i);
					Vector<Double> r1 = population.get(randomIndividuals[0]);
					Vector<Double> r2 = population.get(randomIndividuals[1]);
					Vector<Double> r3 = population.get(randomIndividuals[2]);	
					Vector<Double> child = recombine(parent, r1, r2, r3, dimension, funct.getDomainsMin(), funct.getDomainsMax());
					
					//Replacement
					double childFitness = funct.f(child) + (funct.violation(child) * ADDPENALTYCOEFF);
					currentEvaluations++;
					double parentFitness = funct.f(parent) + (funct.violation(parent) * ADDPENALTYCOEFF);
					currentEvaluations++;

					if(childFitness > parentFitness) {
						newPopulation.add(parent);
						
						if(funct.f(parent) < bestFitness) {
							bestFitness = funct.f(parent);
							currentEvaluations++;
							currentEvaluations++;
						}
					}
					else {
						newPopulation.add(child);
						
						if(funct.f(child) < bestFitness) {
							bestFitness = funct.f(child);
							currentEvaluations++;
							currentEvaluations++;
						}
					}
				}
				else if(cht == 3) { //PieceWise
					//Mutation and Crossover
					int[] randomIndividuals = getRandomIndividuals(i);
					Vector<Double> parent = population.get(i);
					Vector<Double> r1 = population.get(randomIndividuals[0]);
					Vector<Double> r2 = population.get(randomIndividuals[1]);
					Vector<Double> r3 = population.get(randomIndividuals[2]);	
					Vector<Double> child = recombine(parent, r1, r2, r3, dimension, funct.getDomainsMin(), funct.getDomainsMax());
					
					//Replacement
					double childFitness = funct.f(child);
					currentEvaluations++;
					double parentFitness = funct.f(parent);
					currentEvaluations++;
					double childViolation = funct.violation(child);
					double parentViolation = funct.violation(parent);

					if((childViolation == 0) && (parentViolation == 0)) { //Both Valid, take best fitness
						if(childFitness > parentFitness) {
							newPopulation.add(parent);
							
							if(parentFitness < bestFitness) {
								bestFitness = parentFitness;
							}
						}
						else {
							newPopulation.add(child);
							
							if(childFitness < bestFitness) {
								bestFitness = childFitness;
							}
						}
					}
					else if((childViolation == 0) && (parentViolation != 0)) { //If parent invalid and child valid, take child
						newPopulation.add(child);
						
						if(childFitness < bestFitness) {
							bestFitness = childFitness;
						}
					}
					else if((childViolation != 0) && (parentViolation == 0)) { //If child invalid and parent valid, take parent
						newPopulation.add(parent);
						
						if(parentFitness < bestFitness) {
							bestFitness = parentFitness;
						}
					}
					else { //Both invalid, take most valid
						if(childViolation > parentViolation) {
							newPopulation.add(parent);
						}
						else {
							newPopulation.add(child);
							
							if(childFitness < bestFitness) {
								bestFitness = childFitness;
							}
						}
					}
				}
			}
			
			//Move over to next generation
			population = newPopulation;
			newPopulation = new ArrayList<Vector<Double>>(POPSIZE);
		}
		
		return bestFitness;
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
}
