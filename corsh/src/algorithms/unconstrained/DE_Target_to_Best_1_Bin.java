package algorithms.unconstrained;

import algorithms.AbstractAlgorithm;
import general.*;
import problems.AbstractProblem;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by David on 2015-09-26.
 */
public class DE_Target_to_Best_1_Bin extends AbstractAlgorithm {


    private static double CR = 0.5; //Crossover Constant
    private static double F = 0.5; //Scaling Factor
    private static int POPSIZE = 100; //Pop Size

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
                CurrentPopulationPx.get(i).add(RandFunctions.getRandom(problem.getDomainsMin()[j],
                        problem.getDomainsMax()[j]));
            }
        }

        //Initialise Printer
        ProgressionPrinter printer = new ProgressionPrinter(Simulation.simRunNumber, dimension, getName(), problem.getName());

        printer.saveGeneration(CurrentPopulationPx);

        //DE
        while (currentEvaluations < maxEvaluations) { //Until stopping condition is met
            for (int i = 0; i < POPSIZE; i++) { //For each individual in Pop
                //Mutation and Crossover
                int[] randomIndividuals = getRandomIndividuals(i);
                Vector<Double> targetVector = CurrentPopulationPx.get(i);
                Vector<Double> r1 = CurrentPopulationPx.get(randomIndividuals[0]);
                Vector<Double> r2 = CurrentPopulationPx.get(randomIndividuals[1]);
                Vector<Double> bestIndividual = CurrentPopulationPx.get(0);
                for (int j = 0; j < POPSIZE; j++) {
                    if(problem.fitness(CurrentPopulationPx.get(j)) > problem.fitness(bestIndividual)){
                        bestIndividual = CurrentPopulationPx.get(j);
                    }
                }

                Vector<Double> trialVector = recombine(targetVector, r1, r2, bestIndividual, dimension,
                        problem.getDomainsMin(), problem.getDomainsMax());

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

            printer.saveGeneration(CurrentPopulationPx);
        }

        print.printUnconstrainedDEProgressFinal(this.getName(), problem.getName(), problem.getDimension());
        printer.printRun();
        Solution result = new Solution(bestFitness, bestPosition);

        return result;

    }

    //Recombine
    private static Vector<Double> recombine(Vector<Double> targetVector, Vector<Double> ran1, Vector<Double> ran2,
                                            Vector<Double> bestIndividual, int dimension, double[] min, double[] max) {

        int jrandom = (int) RandFunctions.getRandom(0,dimension-1);
        Vector<Double> trialVector = new Vector<Double>(dimension);

        //Create the trialVector from the base vector and mutant vector
        for(int j = 0; j < dimension; j++) {
            if((RandFunctions.getRandom(0,1) < CR) || (j == jrandom)) {

                double v = targetVector.get(j) + F*(bestIndividual.get(j) - targetVector.get(j)) - F*(ran1.get(j) - ran2.get(j));

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

    //Pick 2 random unique vector indices, excluding parent

    private static int[] getRandomIndividuals(int targetVectorIndex) {
        int[] result = new int[]{0, 0};

        result[0] = (int) RandFunctions.getRandom(0, POPSIZE);
        result[1] = (int) RandFunctions.getRandom(0, POPSIZE);

        while(result[0] == targetVectorIndex) {
            result[0] = (int) RandFunctions.getRandom(0, POPSIZE);
        }

        while((result[1] == result[0]) || (result[1] == targetVectorIndex)) {
            result[1] = (int) RandFunctions.getRandom(0, POPSIZE);
        }


        return result;
    }


    public String getName() {
        return "DE_Target_to_Best_1_Bin";
    }
}

