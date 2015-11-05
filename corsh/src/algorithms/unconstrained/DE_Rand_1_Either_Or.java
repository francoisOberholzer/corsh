package algorithms.unconstrained;

import algorithms.AbstractAlgorithm;
import general.Print;
import general.RandFunctions;
import general.Solution;
import problems.AbstractProblem;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by David on 2015-09-26.
 */
public class DE_Rand_1_Either_Or extends AbstractAlgorithm {
    private static double CR = 0.5; //Crossover Constant
    private static double F = 0.5; //Scaling Factor
    private static int POPSIZE = 100; //Pop Size
    private static double PF = 0.5; // mutation probability

    public Solution run(AbstractProblem problem, int maxEvaluations) {
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

                Vector<Double> trialVector;

                if(RandFunctions.getRandom(0,1) < PF) {
                    trialVector = recombineEither(targetVector, r1, r2, r3, dimension, problem.getDomainsMin(), problem.getDomainsMax());
                }
                else{
                    trialVector = recombineOr(targetVector, r1, r2, r3, dimension, problem.getDomainsMin(), problem.getDomainsMax());
                }

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

        print.printUnconstrainedDEProgressFinal(this.getName(), problem.getName(), problem.getDimension());

        Solution result = new Solution(bestFitness, bestPosition);

        return result;

    }


    //Recombine Either
    private static Vector<Double> recombineEither(Vector<Double> targetVector, Vector<Double> ran1, Vector<Double> ran2,
                                                  Vector<Double> ran3, int dimension, double[] min, double[] max) {
        int jrandom = (int) RandFunctions.getRandom(0,dimension-1);
        Vector<Double> trialVector = new Vector<Double>(dimension);

        //Create the trialVector from the base vector and mutant vector
        for(int j = 0; j < dimension; j++) {
            if((RandFunctions.getRandom(0,1) < CR) || (j == jrandom)) {
                double v = ran3.get(j) + (F * (ran1.get(j) - ran2.get(j)));

                //Check bounds
                int counter = 0; //Prevent infinite loop
                while(v > max[j] && counter < 1000) {
                    v = (targetVector.get(j) + max[j]) * RandFunctions.getRandom(0.0, 1.0);
                    counter++;
                }
                counter = 0;
                while(v < min[j] && counter < 1000) {
                    v = (targetVector.get(j) + min[j]) * RandFunctions.getRandom(0.0, 1.0);
                    counter++;
                }

                if(v > max[j] || v < min[j]) {
                    trialVector.add(targetVector.get(j));
                }
                else {
                    trialVector.add(v);
                }
            }
            else {
                trialVector.add(targetVector.get(j));
            }
        }

        return trialVector;
    }

    //Recombine Or
    private static Vector<Double> recombineOr(Vector<Double> targetVector, Vector<Double> ran1, Vector<Double> ran2,
                                              Vector<Double> ran3, int dimension, double[] min, double[] max) {
        int jrandom = (int) RandFunctions.getRandom(0,dimension-1);
        Vector<Double> trialVector = new Vector<Double>(dimension);

        //Create the trialVector from the base vector and mutant vector
        for(int j = 0; j < dimension; j++) {
            if((RandFunctions.getRandom(0,1) < CR) || (j == jrandom)) {
                double v = ran3.get(j) +0.5*(F+1) * ( ran1.get(j) + ran2.get(j) - 2*ran3.get(j));

                //Check bounds
                if(v > max[j]) {
                    v = (targetVector.get(j) + max[j]) * RandFunctions.getRandom(0.0, 1.0);
                }
                if(v < min[j]) {
                    v = (targetVector.get(j) + min[j]) * RandFunctions.getRandom(0.0, 1.0);
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
        return "DE_Rand_1_Either_Or";
    }
}
