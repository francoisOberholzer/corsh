package algorithms.unconstrained;

import java.util.ArrayList;
import java.util.Vector;

import algorithms.AbstractAlgorithm;
import problems.AbstractProblem;
import general.Print;
import general.RandFunctions;

/**
 * Created by David on 2015-09-10.
 *
 * Naming conventions come from:
 * Differential Evolution: A practical Approach To Global Optimization
 * by:
 * Kennith V. Price; Rainer M. Storm; Jouni A. Lampinen
 * ISBN-10 3-540-20950-6 Springer Berlin Heidelberg New York
 * ISBN-13 978-3-540-20950-8 Springer Berlin Heidelberg New York
 *
 * Refer to Pages 42,139
 */
public class DE_Rand_1_Bin_Classic extends AbstractAlgorithm {
    private static double CR = 0.5; //Crossover Constant
    private static double F = 0.5; //Scaling Factor
    private static int POPSIZE = 100; //Pop Size

    public double[] run(AbstractProblem problem, int maxEvaluations) {
        Vector<Double> bestPosition = null;
        double bestFitness = Double.MAX_VALUE;
        int currentEvaluations = 0;
        int evaluationsTillNextPrint = POPSIZE;
        int dimension = problem.getDimension();
        maxEvaluations = maxEvaluations * dimension;
        Print print = new Print();


        //Initialize Population
        ArrayList<Vector<Double>> CurrentPopulationPx = new ArrayList<Vector<Double>>();
        ArrayList<Vector<Double>> TrialPopulationPvPu = new ArrayList<Vector<Double>>();
        for (int i = 0; i < POPSIZE; i++) {
            CurrentPopulationPx.add(new Vector<Double>());
            for (int j = 0; j < dimension; j++) {
                CurrentPopulationPx.get(i).add(RandFunctions.getRandom(problem.getDomainsMin()[j], problem.getDomainsMax()[j]));
            }
        }

        //DE
        while (currentEvaluations < maxEvaluations) { //Until stopping condition is met
            for (int i = 0; i < POPSIZE; i++) { //For each individual in Pop
                //Mutation and Crossover
                int[] randomIndividuals = getRandomIndividuals(i);
                Vector<Double> targetVector = CurrentPopulationPx.get(i);
                Vector<Double> r1 = CurrentPopulationPx.get(randomIndividuals[0]);
                Vector<Double> r2 = CurrentPopulationPx.get(randomIndividuals[1]);
                Vector<Double> r3 = CurrentPopulationPx.get(randomIndividuals[2]);
                Vector<Double> trialVector = recombine(targetVector, r1, r2, r3, dimension, problem.getDomainsMin(), problem.getDomainsMax());

                //Replacement
                double trialVectorFitness = problem.fitness(trialVector);
                currentEvaluations++;
                double targetVectorFitness = problem.fitness(targetVector);
                currentEvaluations++;

                if(trialVectorFitness > targetVectorFitness) {
                    TrialPopulationPvPu.add(targetVector);

                    if(targetVectorFitness < bestFitness) {
                        bestFitness = targetVectorFitness;
                        bestPosition = targetVector;
                    }
                }
                else {
                    TrialPopulationPvPu.add(trialVector);

                    if(trialVectorFitness < bestFitness) {
                        bestFitness = trialVectorFitness;
                        bestPosition = trialVector;
                    }
                }

                if(currentEvaluations > evaluationsTillNextPrint) {
                    evaluationsTillNextPrint += POPSIZE;
                    print.printUnconstrainedDEProgress(bestPosition, bestFitness);
                }
            }

            //Move over to next generation
            CurrentPopulationPx = TrialPopulationPvPu;
            TrialPopulationPvPu = new ArrayList<Vector<Double>>(POPSIZE);
        }

        print.printUnconstrainedDEProgressFinal(this.getName(), problem.getName());

        double[] result = new double[]{bestFitness, 0};

        return result;

    }

    //Recombine
    private static Vector<Double> recombine(Vector<Double> targetVector, Vector<Double> ran1, Vector<Double> ran2, Vector<Double> ran3, int dimension, double[] min, double[] max) {
        int jrandom = (int) RandFunctions.getRandom(0,dimension-1);
        Vector<Double> trialVector = new Vector<Double>(dimension);

        //Create the trialVector from the base vector and mutant vector
        for(int j = 0; j < dimension; j++) {
            if((RandFunctions.getRandom(0,1) < CR) || (j == jrandom)) {
                double v = ran3.get(j) + (F * (ran1.get(j) - ran2.get(j)));

                //check bounds
                if(v > max[j]) {
                    while(v > max[j]) {
                        v = (targetVector.get(j) + max[j]) * RandFunctions.getRandom(0.0, 1.0);
                    }
                }
                else if(v < min[j]) {
                    while(v < min[j]) {
                        v = (targetVector.get(j) + min[j]) * RandFunctions.getRandom(0.0, 1.0);
                    }
                }

                trialVector.add(v);
            }
            else {
                trialVector.add(targetVector.get(j));
            }
        }

        return trialVector;
    }

    //Pick 3 random unique vector indices, excluding parent

    private static int[] getRandomIndividuals(int targetVectorIndex) {
        int[] result = new int[]{0, 0, 0};

        result[0] = (int) RandFunctions.getRandom(0, POPSIZE);
        result[1] = (int) RandFunctions.getRandom(0, POPSIZE);
        result[2] = (int) RandFunctions.getRandom(0, POPSIZE);

        while(result[0] == targetVectorIndex) {
            result[0] = (int) RandFunctions.getRandom(0, POPSIZE);
        }

        while((result[1] == result[0]) || (result[1] == targetVectorIndex)) {
            result[1] = (int) RandFunctions.getRandom(0, POPSIZE);
        }

        while((result[2] == result[0]) || (result[2] == result[1]) || (result[2] == targetVectorIndex)) {
            result[2] = (int) RandFunctions.getRandom(0, POPSIZE);
        }

        return result;
    }


    public String getName() {
        return "DE_Rand_1_Bin_Classic";
    }


}
