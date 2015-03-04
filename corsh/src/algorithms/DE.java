package algorithms;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Vector;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import functions.AbstractFunction;
import general.MiscFunctions;

public class DE {
	private static double CR = 0.5; //Crossover Constant
	private static double F = 0.5; //Scaling Factor
	private static int POPSIZE = 100; //Pop Size
	private static int MAXGEN = 200; //Maximum Generations, Stopping Condition
	
	public static String write(AbstractFunction funct, double min, double max) {
		StringBuilder result = new StringBuilder();
		Mean m = new Mean();
		StandardDeviation std = new StandardDeviation();
		
		double[] result10d = new double[10];
		double[] result30d = new double[30];
		
		for(int i = 0; i < 10; i++) {
			result10d[i] = evolution(funct, min, max, 10);
		}
		
		for(int i = 0; i < 30; i++) {
			result30d[i] = evolution(funct, min, max, 30);
		}
		
		Arrays.sort(result10d);
		Arrays.sort(result30d);
		
		result.append("\nDE \n");
		
		result.append("10D\n");
		result.append("Mean DE: " + m.evaluate(result10d, 0, 10) + "\n");
		result.append("Max  DE: " + result10d[9] + "\n");
		result.append("Min  DE: " + result10d[0] + "\n");
		result.append("Standard Deviation: " + std.evaluate(result10d) + "\n");

		result.append("\n30D\n");
		result.append("Mean DE: " + m.evaluate(result30d, 0, 30) + "\n");
		result.append("Max  DE: " + result30d[29] + "\n");
		result.append("Min  DE: " + result30d[0] + "\n");
		result.append("Standard Deviation: " + std.evaluate(result30d) + "\n");

		return result.toString();
	}
	
	private static double evolution(AbstractFunction funct, double min, double max, int dimension) {
		double bestFitness = Double.MAX_VALUE;
		
		//Initialize Population		
		ArrayList<Vector<Double>> population = new ArrayList<Vector<Double>>();
		ArrayList<Vector<Double>> newPopulation = new ArrayList<Vector<Double>>();
		for(int i = 0; i < POPSIZE; i++) {
			population.add(new Vector<Double>());
			for(int j = 0; j < dimension; j++) {
				population.get(i).add(MiscFunctions.getRandom(min, max));
			}
		}
		
		//DE
		for(int gen = 0; gen < MAXGEN; gen++) { //For each generation
			for(int i = 0; i < POPSIZE; i++) { //For each individual in Pop
				//Mutation/Crossover
				int[] randomIndividuals = getRandomIndividuals(dimension);
				Vector<Double> parent = population.get(i);
				Vector<Double> r1 = population.get(randomIndividuals[0]);
				Vector<Double> r2 = population.get(randomIndividuals[1]);
				Vector<Double> r3 = population.get(randomIndividuals[2]);	
				Vector<Double> child = recombine(parent, r1, r2, r3, dimension, min, max);
				
				//Replacement
				double childFitness = funct.f(child);	
				if(childFitness > funct.f(parent)) {
					newPopulation.add(parent);
				}
				else {
					newPopulation.add(child);
					
					if(childFitness < bestFitness) {
						bestFitness = childFitness;
					}
				}
			}
			
			//Move over to next generation
			population = newPopulation;
			newPopulation = new ArrayList<Vector<Double>>(POPSIZE);
		}
		
		return bestFitness;
	}
	
	private static Vector<Double> recombine(Vector<Double> parent, Vector<Double> ran1, Vector<Double> ran2, Vector<Double> ran3, int dimension, double min, double max) {
		//System.out.println("Start recombine");
		int jrandom = (int) MiscFunctions.getRandom(0,dimension-1);
		Vector<Double> child = new Vector<Double>(dimension);
		
		//System.out.println("Jrandom set to " + jrandom);
		//System.out.println("Parent " + parent.toString());
		//System.out.println("Ran1 " + ran1.toString());
		//System.out.println("Ran2 " + ran2.toString());
		//System.out.println("Ran3 " + ran3.toString());
		
		for(int j = 0; j < dimension; j++) {
			//System.out.println("J = " + j);
			if((MiscFunctions.getRandom(0,1) < CR) || (j == jrandom)) {
				//System.out.println("Random Succeeded");
				double v = ran3.get(j) + (F * (ran1.get(j) - ran2.get(j)));
				
				//Repair
				if(v > max) {
					v = (parent.get(j) + max) / 2;
				}
				else if(v < min) {
					v = (parent.get(j) + min) / 2;
				}
				
				child.add(v);
				//System.out.println("Adding v " + v);
			}
			else {
				child.add(parent.get(j));
			}
		}
		
		//System.out.println("End recombine");
		return child;
	}
	
	private static int[] getRandomIndividuals(int dim) {
		int[] result = new int[]{0, 0, 0};
		
		result[0] = (int) MiscFunctions.getRandom(0, POPSIZE);
		result[1] = (int) MiscFunctions.getRandom(0, POPSIZE);
		result[2] = (int) MiscFunctions.getRandom(0, POPSIZE);
		
		while(result[1] == result[0]) {
			result[1] = (int) MiscFunctions.getRandom(0, POPSIZE);
		}
		
		while((result[2] == result[0]) || (result[2] == result[1])) {
			result[2] = (int) MiscFunctions.getRandom(0, POPSIZE);
		}
		
		return result;
	}
}
